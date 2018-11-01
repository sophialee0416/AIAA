package comsophialee0416aiaa.httpsgithub.appaiaa

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prof.rssparser.Article
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.rssfeed_cards.view.*
import org.jsoup.Jsoup
import android.os.AsyncTask
import java.io.IOException

class MyAdapter(private val links:ArrayList<Article>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var linksToMap: HashMap<String, Int> = hashMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {

        val itemLayoutView:View =  LayoutInflater.from(parent.context)
                .inflate(R.layout.rssfeed_cards, null)

        itemLayoutView.setOnClickListener {
            val url = links[linksToMap[itemLayoutView.card_Title.text] as Int].link
            Log.i("howdy", url)
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            parent.context.startActivity(browserIntent)
        }

        return MyViewHolder(itemLayoutView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        linksToMap[links[position].title] = position
        holder.cardTitle.text = links[position].title
        holder.cardContent.text = Html.fromHtml(links[position].description)
        val task = GetImageLink()
        task.title = links[position].title
        task.execute()
    }

    override fun getItemCount(): Int {
        return links.size
    }

    class MyViewHolder(itemLayoutView: View)
        : RecyclerView.ViewHolder(itemLayoutView) {

        val cardTitle = itemLayoutView.findViewById<TextView>(R.id.card_Title)
        val cardContent = itemLayoutView.findViewById<TextView>(R.id.card_content)
        //val itemUrl = itemLayoutView.findViewById<TextView>(R.id.item_url)

    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetImageLink : AsyncTask<Void, Void, Void>() {

        var title : String = ""

        override fun doInBackground(vararg params : Void): Void? {
            if(null == links[linksToMap[title] as Int].image) {
                try {
                    val document = Jsoup.connect(links[linksToMap[title] as Int].link).get()
                    links[linksToMap[title] as Int].image = getActualImage(document?.select("#ctl00_ContentPlaceHolder1_ContentBlock2 font a")?.first()?.attr("href"))
//                    Log.i("hello", "howdy " + links[linksToMap[title] as Int].image)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return null
        }

        fun getActualImage(imageLink : String?) : String? {
            if(imageLink == null) {
                return null
            }
            val invalid : Boolean = "/uploadedImages/Industry_News/" == imageLink.substring(0, 30)
            || "http://archive" == imageLink.substring(0,14)
            || "https://aerospaceamerica" == imageLink.substring(0,24)
            || "https://www.space.com" == imageLink.substring(0, 21)
            || "https://www.orbitalatk.com" == imageLink.substring(0,26)
            || "https://www.dropbox.com/" == imageLink.substring(0, 24)

            if(invalid) {
                return null
            }
            else if("https://commons.wikimedia.org" == imageLink.substring(0,29)) {
                return Jsoup.connect(imageLink).get()?.select("fullImageLink a")?.attr("href")
            }
            return imageLink
        }
    }
}

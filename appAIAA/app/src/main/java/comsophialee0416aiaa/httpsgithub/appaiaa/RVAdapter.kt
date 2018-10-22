package comsophialee0416aiaa.httpsgithub.appaiaa

import android.support.v7.widget.RecyclerView;
import android.text.Html
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.prof.rssparser.Article
import android.widget.Toast
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.rssfeed_cards.view.*
import android.support.v4.content.ContextCompat.startActivity
import org.jsoup.Jsoup
import android.app.ProgressDialog
import android.os.AsyncTask
import android.util.Log
import java.io.IOException

class MyAdapter(private val links:ArrayList<Article>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var linksToMap: HashMap<String, Int> = hashMapOf()
    var currentTitle = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {

        val itemLayoutView:View =  LayoutInflater.from(parent.context)
                .inflate(R.layout.rssfeed_cards, null)

        itemLayoutView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var url = links[linksToMap[itemLayoutView.card_Title.text] as Int].link
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                parent.context.startActivity(browserIntent)
            }
        })

        return MyViewHolder(itemLayoutView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        currentTitle = links[position].title
        linksToMap[currentTitle] = position
        holder.cardTitle.text = currentTitle
        holder.cardContent.text = Html.fromHtml(links[position].description)
        if(null == links[position].image) {
            GetImageLink().execute()
        }
        else {
            Log.i("hello", "covered already")
        }
//        holder.itemUrl.text = links[position].url

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

    private inner class GetImageLink : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params : Void): Void? {
            try {
                val document = Jsoup.connect(links[linksToMap[currentTitle] as Int].link).get()
                if(document != null) {
                    val imageDiv = document.select("#ctl00_ContentPlaceHolder1_ContentBlock2 font a")
                    if(imageDiv != null) {
                        val imageFirst = imageDiv.first()
                                if(imageFirst != null) {
                                    val imageLink = imageFirst.attr("href")
                                    if(imageLink != null) {
                                        links[linksToMap[currentTitle] as Int].image = imageLink
                                        Log.i("hello", links[linksToMap[currentTitle] as Int].image)
                                    }
                                }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }
    }
}

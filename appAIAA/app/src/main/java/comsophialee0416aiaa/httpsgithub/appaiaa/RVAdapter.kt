package comsophialee0416aiaa.httpsgithub.appaiaa

import android.support.v7.widget.RecyclerView;
import android.text.Html
import android.util.Log
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




class MyAdapter(private val links:ArrayList<Article>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var linksToMap: HashMap<String, Int> = hashMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {

        val itemLayoutView:View =  LayoutInflater.from(parent.context)
                .inflate(R.layout.rssfeed_cards, null)

        itemLayoutView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var url = links[linksToMap[itemLayoutView.card_Title.text] as Int].link
                Log.i("howdy", url)
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(browserIntent)
            }
        })

        return MyViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        linksToMap[links[position].title] = position
        holder.cardTitle.text = links[position].title
        holder.cardContent.text = Html.fromHtml(links[position].description)
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
}
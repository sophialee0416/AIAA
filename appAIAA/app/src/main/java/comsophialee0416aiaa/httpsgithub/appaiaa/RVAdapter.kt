package comsophialee0416aiaa.httpsgithub.appaiaa

import android.support.v7.widget.RecyclerView;
import android.text.Html
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.prof.rssparser.Article

class MyAdapter(private val links:ArrayList<Article>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {

        val itemLayoutView:View =  LayoutInflater.from(parent.context)
                .inflate(R.layout.rssfeed_cards, null)

        val vh:MyViewHolder = MyViewHolder(itemLayoutView)
        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardTitle.text = links[position].title
        holder.cardContent.text = Html.fromHtml(links[position].description)
        //holder.itemUrl.text = links[position].url
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
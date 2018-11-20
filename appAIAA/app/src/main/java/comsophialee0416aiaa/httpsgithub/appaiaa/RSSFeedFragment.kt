package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*
import com.prof.rssparser.Article
import com.prof.rssparser.Parser


//1
class RSSFeedFragment : Fragment() {
    //2
    companion object {

        fun newInstance(): RSSFeedFragment {
            return RSSFeedFragment()
        }
    }
    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_rssfeed, container, false)

        //url of RSS feed
        val urlString = "https://www.aiaa.org/IndustryNewsRss.aspx"
        val parser = Parser()
        parser.execute(urlString)
        parser.onFinish(object : Parser.OnTaskCompleted {

            override fun onTaskCompleted(list: ArrayList<Article>) {
                //what to do when the parsing is done
                //the Array List contains all article's data. For example you can use it for your adapter.

                //1. Get a reference to recyclerView
                val recyclerView = rootView.findViewById(R.id.recycler_rssfeed) as RecyclerView

                // 2. set layoutManger
                recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                // this is data fro recycler view
                val adapter:RecyclerView.Adapter<MyAdapter.MyViewHolder> = MyAdapter(list)
                recyclerView.adapter = adapter
            }

            override fun onError() {
                //what to do in case of error
            }
        })
        return rootView
    }

}
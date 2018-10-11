package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*


//1
class RSSFeedFragment : Fragment() {

    //2
    companion object {

        fun newInstance(): RSSFeedFragment {
            return RSSFeedFragment()
        }
    }

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var viewAdapter: RecyclerView.Adapter<*>
//    private lateinit var viewManager: RecyclerView.LayoutManager


    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootView = inflater?.inflate(R.layout.fragment_rssfeed, container, false)

        //1. Get a reference to recyclerView
        val recyclerView = rootView.findViewById(R.id.recycler_rssfeed) as RecyclerView

        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // this is data fro recycler view

        val adapter:RecyclerView.Adapter<MyAdapter.MyViewHolder> = MyAdapter(getListData())
        recyclerView.adapter = adapter;

        return rootView
    }

    private fun getListData(): List<Card> {
        val links = LinkedList<Card>()

        var link = Card()
        link.title = "Article One";
        link.content ="Content One";
//        link.url = "hmkcode.com";

        links.add(link)

        link = Card()
        link.title = "Article Two";
        link.content ="Content Two";
//        link.url = "hmkcode.com";

        links.add(link)

        link = Card()
        link.title = "Article Three";
        link.content ="Content Three";
//        link.url = "hmkcode.com";

        links.add(link)
        return links
    }

}
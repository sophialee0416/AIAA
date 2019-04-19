package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import com.prof.rssparser.Article
import com.prof.rssparser.Parser
import kotlin.collections.ArrayList
import android.widget.RelativeLayout
import android.widget.Toast

//1
class RSSFeedFragment : Fragment() {
    var articleList:ArrayList<Article> = arrayListOf()
    var partialList:ArrayList<Article> = arrayListOf()

    lateinit var recyclerView:RecyclerView
    lateinit var adapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>
    lateinit var bottomLayout:RelativeLayout
    var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    // variables for scroll listener
    private var userScrolled = true
    var pastVisibleItems:Int = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    private var imagesPerLoad:Int = 10

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
        //1. Get a reference to recyclerView
        recyclerView = rootView.findViewById(R.id.recycler_rssfeed) as RecyclerView

        // 2. set layoutManger
        recyclerView.layoutManager = linearLayoutManager

        bottomLayout = rootView.findViewById(R.id.loadItemsLayout_recyclerView) as RelativeLayout

        //url of RSS feed
        val urlString = "https://www.aiaa.org/IndustryNewsRss.aspx"
        val parser = Parser()
        parser.execute(urlString)
        parser.onFinish(object : Parser.OnTaskCompleted {

            override fun onTaskCompleted(list: ArrayList<Article>) {
                //what to do when the parsing is done
                //the Array List contains all article's data. For example you can use it for your adapter.
                articleList = list

                populateRecyclerView()

                adapter = MyAdapter(partialList)
                recyclerView.adapter = adapter

                Log.i("howdy", "howdy");

                implementScrollListener()
            }

            override fun onError() {
                //what to do in case of error
            }
        })
        return rootView
    }

    private fun implementScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView?,
                                              newState: Int) {

                super.onScrollStateChanged(recyclerView, newState)

                // If scroll state is touch scroll then set userScrolled
                // true
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    userScrolled = true
                }

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int,
                                    dy: Int) {

                super.onScrolled(recyclerView, dx, dy)
                // Here get the child count, item count and visibleitems
                // from layout manager

                visibleItemCount = linearLayoutManager.childCount
                totalItemCount = linearLayoutManager.itemCount
                pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition()

                Log.i("onScrolled", "$visibleItemCount, $pastVisibleItems, $totalItemCount")
                // Now check if userScrolled is true and also check if
                // the item is end then update recycler view and set
                // userScrolled to false
                if (userScrolled && visibleItemCount + pastVisibleItems == totalItemCount) {
                    userScrolled = false

                    updateRecyclerView()
                }

            }

        })

    }

    private fun populateRecyclerView() {
        for(i in partialList.size..partialList.size + imagesPerLoad) {
            partialList.add(articleList[i])
        }
    }

    private fun updateRecyclerView() {
        bottomLayout.visibility = View.VISIBLE

        Handler().postDelayed({
            // Loop for 3 items
            populateRecyclerView()
            adapter.notifyDataSetChanged()// notify adapter

            // Toast for task completion
            Toast.makeText(activity, "Items Updated.",
                    Toast.LENGTH_SHORT).show()

            // After adding new data hide the view.
            bottomLayout.visibility = View.GONE
        }, 5000)
    }

}
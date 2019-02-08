package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_rssfeed -> {
                val rssFeedFragment = RSSFeedFragment.newInstance()
                openFragment(rssFeedFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_calculator -> {
                val calculatorFragment = CalculatorFragment.newInstance()
                openFragment(calculatorFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_videos -> {
                val videosFragment = VideosFragment.newInstance()
                openFragment(videosFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}

package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_rssfeed -> {
                message.setText(R.string.title_rssfeed)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_calculator -> {
                message.setText(R.string.title_calculator)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_videos -> {
                message.setText(R.string.title_videos)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

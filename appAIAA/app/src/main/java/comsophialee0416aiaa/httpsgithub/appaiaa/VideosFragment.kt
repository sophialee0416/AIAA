package comsophialee0416aiaa.httpsgithub.appaiaa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_videos.*

//1
class VideosFragment : Fragment() {

    lateinit var go: Button


    //2
    companion object {

        fun newInstance(): VideosFragment {
            return VideosFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View = inflater.inflate(R.layout.fragment_videos, container, false)
        this.go = view.findViewById(R.id.go_Button) as Button
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_Button.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ckOJChcFP2g"))
            startActivity(i)
        }
    }
}
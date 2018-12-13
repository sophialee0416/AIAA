package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_videos.*

//1
class VideosFragment : Fragment() {

    lateinit var play: Button
    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    //2
    companion object {
//        val VIDEO_ID: String = "ckOJChcFP2g"
//        val YOUTUBE_API_KEY: String = "AIzaSyC1umsPU8msFm4U4ZBmxhqgY-7Q53VSFao"

        fun newInstance(): VideosFragment {
            return VideosFragment()
        }
    }

    //3

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initUI()
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_videos, container, false)
//        this.play = view.findViewById(R.id.playButton) as Button



//        this.youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
//            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer, p2: Boolean) {
//                youtubePlayer.loadVideo(VIDEO_ID)
//            }
//
//            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
//                System.out.print("hi")
//            }
//
//        }
//
//        play.setOnClickListener {
//            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
//        }
//


        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        this.youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
//            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer, p2: Boolean) {
//                youtubePlayer.loadVideo(VIDEO_ID)
//            }
//
//            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
//                System.out.print("hi")
//            }
//
//        }
//
//        play.setOnClickListener {
//            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
//        }
//    }

//    private fun initUI() {
//        this.youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
//            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer, p2: Boolean) {
//                youtubePlayer.loadVideo(VIDEO_ID)
//            }
//
//            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
//                System.out.print("hi")
//            }
//
//        }
//
//        play.setOnClickListener(View.OnClickListener { youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit) })
////        play.setOnClickListener(View.OnClickListener { v -> youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit) })
//    }


}
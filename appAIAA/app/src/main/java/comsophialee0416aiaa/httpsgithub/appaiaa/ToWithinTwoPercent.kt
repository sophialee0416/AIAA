package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ToWithinTwoPercent : Fragment() {

    companion object {
        fun newInstance(): ToWithinTwoPercent {
            return ToWithinTwoPercent()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.to_within_two_percent, container, false)
    }
}
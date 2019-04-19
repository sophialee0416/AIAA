package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class EulerConstant : Fragment() {

    companion object {
        fun newInstance(): EulerConstant {
            return EulerConstant()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Euler Constant"
        return inflater.inflate(R.layout.euler_mascheroni_constant, container, false)
    }
}
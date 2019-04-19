package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.list_naa.*

class NumericalAndAlgebraic : Fragment() {

    lateinit var gainInDecibelsButton: Button
    lateinit var toWithinTwoButton: Button
    lateinit var eulerConstantButton: Button

    companion object {
        fun newInstance(): NumericalAndAlgebraic {
            return NumericalAndAlgebraic()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.list_naa, container, false)
        this.gainInDecibelsButton = rootView.findViewById(R.id.button_gain_in_decibels) as Button
        this.toWithinTwoButton = rootView.findViewById(R.id.button_to_within_two) as Button
        this.eulerConstantButton = rootView.findViewById(R.id.button_euler_mascheroni_constant) as Button
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Numerical and Algebraic"
        gainInDecibelsButton.setOnClickListener {
            val gainInDecibelsFragment = GainInDecibelsFormula.newInstance()
            openFragment(gainInDecibelsFragment)
        }
        toWithinTwoButton.setOnClickListener {
            val toWithinTwoPercentFragment = ToWithinTwoPercent.newInstance()
            openFragment(toWithinTwoPercentFragment)
        }
        eulerConstantButton.setOnClickListener {
            val eulerConstantFragment = EulerConstant.newInstance()
            openFragment(eulerConstantFragment)
        }
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_calculator.*

// cards of formulas, same with videos

class CalculatorFragment : Fragment() {

    lateinit var thrusterButton: Button

    companion object {

        fun newInstance(): CalculatorFragment {
            return CalculatorFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_calculator, container, false)
        this.thrusterButton = rootView.findViewById(R.id.thruster_button) as Button
        return rootView
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thrusterButton.setOnClickListener {
            val thrusterFragment = ThrusterFormula.newInstance()
            openFragment(thrusterFragment)
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
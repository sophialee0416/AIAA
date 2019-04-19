package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// cards of formulas, same with videos

class CalculatorFragment : Fragment() {

    lateinit var thrusterButton: Button
    lateinit var numericalAndAlgebraicButton: Button
    lateinit var fppButton: Button

    companion object {

        fun newInstance(): CalculatorFragment {
            return CalculatorFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_calculator, container, false)
        this.thrusterButton = rootView.findViewById(R.id.button_thruster) as Button
        this.numericalAndAlgebraicButton = rootView.findViewById(R.id.button_numerical_and_algebraic) as Button
        this.fppButton = rootView.findViewById(R.id.button_fpp)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thrusterButton.setOnClickListener {
            val thrusterFragment = ThrusterFormula.newInstance()
            openFragment(thrusterFragment)
        }
        numericalAndAlgebraicButton.setOnClickListener {
            val numericalAndAlgebraicFragment = NumericalAndAlgebraic.newInstance()
            openFragment(numericalAndAlgebraicFragment)
        }
        fppButton.setOnClickListener {
            val fppFragment = FundamentalPlasmaParameters.newInstance()
            openFragment(fppFragment)
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
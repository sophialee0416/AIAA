package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.formula_thruster.*

// cards of formulas, same with videos

class ThrusterFormula : Fragment() {

    lateinit var calc: Button

    companion object {

        fun newInstance(): ThrusterFormula {
            return ThrusterFormula()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.formula_thruster, container, false)
        this.calc = rootView.findViewById(R.id.calculate_button) as Button
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calculate_button.setOnClickListener {
            val thrust: Double = thrust_text.text.toString().toDouble()
            val isp: Double = isp_text.text.toString().toDouble()
            val power: Double = power_text.text.toString().toDouble()
            val propellant: Double = propellant_text.text.toString().toDouble()
            val mass: Double = mass_text.text.toString().toDouble()
            val burnDays: Double = burndays_text.text.toString().toDouble()

            val kg: Double = massFlowKg(thrust, isp, propellant)
            val g: Double = massFlowg(kg)
            val anode: Double = anodeEfficiency(thrust, kg, power)
            val burnSec: Double = burnSeconds(burnDays)
            val accelerate: Double = acceleration(thrust, mass)
            val impulse: Double = approxImpulse(thrust, burnSec)
            val massuse: Double = massUsed(kg, burnSec)

            flowkg_value.text = kg.toString()
            flowg_value.text = g.toString()
            anode_value.text = anode.toString()
            burnsec_value.text = burnSec.toString()
            acceleration_value.text = accelerate.toString()
            impulse_value.text = impulse.toString()
            massused_value.text = massuse.toString()
        }
    }

    private fun massFlowKg(thrust: Double, isp: Double, propellant: Double): Double {
        return (thrust / (9.8 * isp) / propellant)
    }

    private fun massFlowg(kg: Double): Double {
        return (kg * 1000 * 3600 * 24 * 30)
    }

    private fun anodeEfficiency(thrust: Double, kg: Double, power: Double): Double {
        return (thrust * thrust) / (2 * kg * power)
    }

    private fun burnSeconds(burnDays: Double): Double {
        return (3600 * 24 * burnDays)
    }

    private fun acceleration(thrust: Double, mass: Double): Double {
        return (thrust / mass)
    }

    private fun approxImpulse(thrust: Double, burnSec: Double): Double {
        return (thrust / (1.3 * burnSec))
    }

    private fun massUsed(kg: Double, burnSec: Double): Double {
        return (kg * burnSec)
    }

}
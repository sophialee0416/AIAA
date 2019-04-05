package comsophialee0416aiaa.httpsgithub.appaiaa

import android.icu.text.NumberFormat
import android.icu.text.ScientificNumberFormatter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.gain_in_decibels.*
import kotlin.math.log10

// cards of formulas, same with videos

class GainInDecibelsFormula : Fragment() {

    lateinit var calc: Button

    companion object {

        fun newInstance(): GainInDecibelsFormula {
            return GainInDecibelsFormula()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.gain_in_decibels, container, false)
        this.calc = rootView.findViewById(R.id.button_calc_gain) as Button
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calc.setOnClickListener {
            //1. declare variables
            val p2: Double = edit_p2.text.toString().toDouble()
            val p1: Double = edit_p1.text.toString().toDouble()

            //2. call method
            val gain: Double = gainInDecibels(p2, p1)

            //3. output
            label_gain_answer.text = String.format("%6.3e",gain)
        }
    }

    private fun gainInDecibels(p2: Double, p1: Double): Double {
        val ans:Double = (10*(log10(p2/p1)))
        return ans
    }
}
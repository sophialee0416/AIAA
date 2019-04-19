package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.electron_gyrofrequency.*

class ElectronGyrofrequencyFormula : Fragment() {

    lateinit var calc: Button

    companion object {
        fun newInstance(): ElectronGyrofrequencyFormula {
            return ElectronGyrofrequencyFormula()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.electron_gyrofrequency, container, false)
        this.calc = rootView.findViewById(R.id.button_calc_eg) as Button
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Electron Gyrofrequency Formula"
        calc.setOnClickListener {
            val wce: String = edit_wce.text.toString()
            val b: String = edit_B.text.toString()

            val freq: Double = electronGyrofrequency(wce, b)

            label_eg_answer.text = String.format("%6.3e", freq)

        }
    }

    private fun electronGyrofrequency(wce: String, b: String): Double {
        var ans: Double
        if (wce.isBlank()) {
            ans = 2.80 * (Math.pow(10.0, 6.0) * b.toDouble())
        }
        else if (b.isBlank()) {
            ans = wce.toDouble() / (2 * Math.PI)
        }
        else if (wce.isBlank() && b.isBlank()) {
            ans = -1.0
        }
        else
            ans = 0.0

        return ans
    }

}
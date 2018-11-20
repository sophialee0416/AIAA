package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_calculator.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.ParseException


class CalculatorFragment : Fragment() {

    lateinit var calc: Button

    companion object {

        fun newInstance(): CalculatorFragment {
            return CalculatorFragment()
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        //Button OnClick Listener
//        calculate_button.setOnClickListener {
//            var input: Double = thrust_text.text.toString().toDouble()
//            var output: Double = massFlow(input);
////            //Reading the "yearInput" EditText view value
////            var year: String = yearInput.text.toString().trim();
////            if (year == "") {
////
////                result.text = "InValid Input"
////
////            } else {
////                var output: String = massFlow(year);
////                //Updating the text of "result" TextView
////                result.text = output;
////            }
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View = inflater.inflate(R.layout.fragment_calculator, container, false)
        this.calc = view.findViewById(R.id.calculate_button) as Button
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calculate_button.setOnClickListener {
            val input: Double = thrust_text.text.toString().toDouble()
            var output: Double = massFlow(input)
            flowkg_value.text = output.toString()
        }
    }

        fun massFlow(input: Double): Double {

//        var year: Int = input.toInt();
//        var currentYear: Int = Calendar.getInstance().get(Calendar.YEAR);
//
//        var Result: String;
//
//        if(currentYear<year || year<1910) {
//
//            return "Enter Correct Year";
//        }else {
//
//            var Age: Int = currentYear - year;
//            Result = " Your are $Age year(s) old ";
//        }
        return input;
    }

}
package comsophialee0416aiaa.httpsgithub.appaiaa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FundamentalPlasmaParameters : Fragment() {

    lateinit var electronGyrofrequencyButton: Button

    companion object {
        fun newInstance(): FundamentalPlasmaParameters {
            return FundamentalPlasmaParameters()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.list_fpp, container, false)
        this.electronGyrofrequencyButton = rootView.findViewById(R.id.button_electron_gyrofrequency) as Button
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        electronGyrofrequencyButton.setOnClickListener {
            val electronGyrofrequencyFragment = ElectronGyrofrequencyFormula.newInstance()
            openFragment(electronGyrofrequencyFragment)
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
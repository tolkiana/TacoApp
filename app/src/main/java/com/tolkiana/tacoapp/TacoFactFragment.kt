package com.tolkiana.tacoapp

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_taco_fact.*

/**
 * A simple [Fragment] subclass.
 */
class TacoFactFragment : Fragment() {

    companion object {
        private const val ARG_TACO_FACT= "tacoFact"

        fun newInstance(tacoFact: TacoFact): TacoFactFragment{
            val arguments = Bundle()
            arguments.putParcelable(ARG_TACO_FACT, tacoFact)
            val fragment = TacoFactFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tacoFactTextView.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        (arguments?.getParcelable(ARG_TACO_FACT) as TacoFact).let {
            tacoFactTextView.text = it.description
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_taco_fact, container, false)
    }
}

package com.tolkiana.tacoapp

import android.os.Bundle
import android.support.v4.app.Fragment
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
            arguments.putSerializable(ARG_TACO_FACT, tacoFact)
            val fragment = TacoFactFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (arguments.getSerializable(ARG_TACO_FACT) as TacoFact)?.let {
            titleTextView.text = it.title
            tacoFactTextView.text = it.description
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_taco_fact, container, false)
    }
}

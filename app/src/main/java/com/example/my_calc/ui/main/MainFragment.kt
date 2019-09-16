package com.example.my_calc.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.my_calc.R
import com.example.my_calc.presenter.CalcPresenter
import org.w3c.dom.Text

class MainFragment : Fragment() {

    private val presenter = CalcPresenter()

    private var numberAndOpOnClickListener = {view: View ->
        if (view is Button) {
            presenter.addExpressionChar(view.text)
            this@MainFragment.view!!.findViewById<TextView>(R.id.expressionInputArea).text = presenter.getExpression()
            this@MainFragment.view!!.findViewById<TextView>(R.id.expressionOverview).text = presenter.getExpression()
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // キー割当
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad0).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad1).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad2).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad3).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad4).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad5).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad6).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad7).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad8).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPad9).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadDot).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadAdd).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadSub).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadMul).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadDiv).setOnClickListener(numberAndOpOnClickListener)
    }


}

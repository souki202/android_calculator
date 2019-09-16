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
import com.example.my_calc.my.ExpressionInputArea
import com.example.my_calc.presenter.CalcPresenter
import com.example.my_calc.my.OnChangeListener
import java.lang.Integer.max
import java.lang.Integer.min

class MainFragment : Fragment() {

    private val presenter = CalcPresenter()
    private var expressionInputArea: ExpressionInputArea? = null;

    private var numberAndOpOnClickListener = {view: View ->
        if (view is Button) {
            val nowCursorPos = expressionInputArea!!.selectionStart
            presenter.addExpressionChar(view.text, nowCursorPos)
            updateExpressionView()
            expressionInputArea!!.setSelection(nowCursorPos + 1, nowCursorPos + 1)
        }
    }

    private var clearClickListener = {_: View ->
        presenter.clearExpression()
        updateExpressionView()
    }

    private var onChangeExpressionListener = OnChangeListener { view: View ->
        if (view is ExpressionInputArea){
            presenter.setExpression(view.text)
            this@MainFragment.view!!.findViewById<TextView>(R.id.expressionOverview).text =
                presenter.getExpression()
            this@MainFragment.view!!.findViewById<TextView>(R.id.answer).text = presenter.getAnswer()
        }
    }

    private var equalClickListener= {_: View ->
        presenter.setExpression(presenter.getAnswer())
        updateExpressionView()
    }

    private var cursorClickListener = {view: View ->
        val editText = this@MainFragment.view!!.findViewById<ExpressionInputArea>(R.id.expressionInputArea)
        val nowPos = editText.selectionStart
        val textLen = editText.text.length
        if (view is Button) {
            if (view.text == resources.getString(R.string.cursorMoveLeft)) {
                editText.setSelection(max(0, nowPos - 1), max(0, nowPos - 1))
            }
            else if (view.text == resources.getString(R.string.cursorMoveRight)) {
                editText.setSelection(min(textLen, nowPos + 1), min(textLen, nowPos + 1))
            }
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
        // 数字キー
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
        // 四則演算キー
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadAdd).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadSub).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadMul).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadDiv).setOnClickListener(numberAndOpOnClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadEqual).setOnClickListener(equalClickListener)
        // クリア
        this@MainFragment.view!!.findViewById<TextView>(R.id.numPadCe).setOnClickListener(clearClickListener)
        // カーソル移動
        this@MainFragment.view!!.findViewById<TextView>(R.id.cursorLeft).setOnClickListener(cursorClickListener)
        this@MainFragment.view!!.findViewById<TextView>(R.id.cursorRight).setOnClickListener(cursorClickListener)

        this@MainFragment.view!!.findViewById<ExpressionInputArea>(R.id.expressionInputArea).setOnChangeListener(onChangeExpressionListener)

        expressionInputArea = this@MainFragment.view!!.findViewById<ExpressionInputArea>(R.id.expressionInputArea)
    }

    fun updateExpressionView() {
        this@MainFragment.view!!.findViewById<ExpressionInputArea>(R.id.expressionInputArea).setText(presenter.getExpression())
        this@MainFragment.view!!.findViewById<TextView>(R.id.expressionOverview).text =
            presenter.getExpression()
        this@MainFragment.view!!.findViewById<TextView>(R.id.answer).text = presenter.getAnswer()
    }
}

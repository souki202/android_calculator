package com.example.my_calc.my

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.EditText
import android.view.inputmethod.InputMethodManager
import android.content.Context.INPUT_METHOD_SERVICE

class ExpressionInputArea : EditText {

    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        setTextIsSelectable(true)
    }

    constructor(context: Context?) : super(context) {
        setTextIsSelectable(true)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setTextIsSelectable(true)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        setTextIsSelectable(true)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER
            || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER
            || keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            val inputMethodManager =
                context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            // キーボード閉じる処理
            inputMethodManager.hideSoftInputFromWindow(
                this.windowToken,
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
            return true
        }
        return super.onKeyUp(keyCode, event)
    }

    private var textChangedListener:OnChangeListener? = null

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        textChangedListener?.event(this)
    }

    fun setOnChangeListener(listener: OnChangeListener) {
        textChangedListener = listener
    }
}
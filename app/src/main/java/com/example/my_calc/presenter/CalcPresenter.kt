package com.example.my_calc.presenter

import org.mariuszgromada.math.mxparser.Expression

class CalcPresenter {
    private var expression = ""

    constructor() {
        clearExpression()
    }

    fun clearExpression() {
        expression = ""
    }

    fun addExpressionChar(char: CharSequence, pos: Int) {
        expression = StringBuilder(expression).insert(pos, char).toString()
    }

    fun setExpression(string: CharSequence) {
        expression = string.toString()
    }

    fun getExpression(): String {
        return expression
    }

    fun getAnswer(): CharSequence {
        val exp = Expression(expression)
        val ans = exp.calculate()
        if (ans == Double.NaN) {
            return ""
        }
        return ans.toString()
    }
}
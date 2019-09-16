package com.example.my_calc.presenter

class CalcPresenter {
    private var expression = ""

    constructor() {}

    fun addExpressionChar(char: CharSequence) {
        expression += char
    }

    fun getExpression(): String {
        return expression
    }

    fun getAnswer() {

    }
}
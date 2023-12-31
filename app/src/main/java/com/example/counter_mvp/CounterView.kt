package com.example.counter_mvp

interface CounterView {
    fun showCount(count: Int)
    fun showToast(text: String)
    fun darkTheme()
    fun lightTheme()
    fun setGreenColor()
}
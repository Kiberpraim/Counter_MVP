package com.example.counter_mvp

class Injector {

    companion object {
        fun getModel() = Model()
        fun getPresenter(view: CounterView) = Presenter(view)
    }
}
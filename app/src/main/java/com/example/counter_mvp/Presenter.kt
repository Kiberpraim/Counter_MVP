package com.example.counter_mvp

class Presenter(var view: CounterView) {

    var model = Injector.getModel()

    fun increment() {
        model.increment()
        view.showCount(model.counter)
        if (model.counter == 10) {
            view.showToast("Поздравляем.")
        }
        if (model.counter == 15) {
            view.setGreenColor()
        }
    }

    fun decrement() {
        model.decrement()
        view.showCount(model.counter)
        if (model.counter == 10) {
            view.showToast("Поздравляем.")
        }
        if (model.counter == 15) {
            view.setGreenColor()
        }
    }

    fun theme() {
        if (model.themeIsDark) {
            view.lightTheme()
            model.themeIsDark = false
        } else {
            view.darkTheme()
            model.themeIsDark = true
        }
    }
}
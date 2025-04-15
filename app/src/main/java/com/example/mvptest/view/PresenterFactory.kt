package com.example.mvptest.view

import com.example.mvptest.view.model.Model

object PresenterFactory {
    fun providePresenter(view: Contract.View): Contract.Presenter {
        val model = Model()
        return Presenter(view, model)
    }
}
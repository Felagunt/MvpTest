package com.example.mvptest.view

interface Contract {
    interface View {

        fun showProgress()

        fun hidProgress()

        fun setString(string: String?)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }
    interface Presenter {

        fun onButtonClick()

        fun onDestroy()
    }

}
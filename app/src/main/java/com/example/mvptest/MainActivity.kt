package com.example.mvptest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mvptest.databinding.ActivityMainBinding
import com.example.mvptest.view.Contract
import com.example.mvptest.view.Presenter
import com.example.mvptest.view.PresenterFactory

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        presenter = PresenterFactory.providePresenter(this) as Presenter

        this.button.setOnClickListener {
            presenter.onButtonClick()
        }
    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE
    }

    override fun hidProgress() {
        progressBar.visibility = View.GONE
        textView.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView.text = string
    }
}
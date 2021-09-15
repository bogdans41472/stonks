package com.boghydan.stonks.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.boghydan.stonks.R
import com.boghydan.stonks.ui.DataStateListener
import com.boghydan.stonks.util.DataState

class MainActivity : AppCompatActivity(), DataStateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        showMainFragment()
    }

    private fun showMainFragment() {
        if (supportFragmentManager.fragments.size == 0) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    MainFragment(),
                    "MainFragment")
                .commit()
        }
    }

    lateinit var viewModel: MainViewModel

    private fun showProgressBar(isVisible: Boolean){
        //TODO
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDataStateChanged(data: DataState<*>?) {
        handleDataStateChange(data)
    }

    private fun handleDataStateChange(data: DataState<*>?) {
        data?.let {
            showProgressBar(true)

            data.message?.let { event ->
                event.getContentIfNotHandled()?.let { message ->
                    showMessage(message)
                }
            }
        }
    }


}
package com.tistory.zladnrms.cehexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tistory.zladnrms.cehexample.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this@MainActivity,
            MainViewModelFactory()
        ).get(MainViewModel::class.java).apply {
            apiFailEvent.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "에러 났어요!", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

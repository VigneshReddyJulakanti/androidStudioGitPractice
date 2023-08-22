package com.example.myapplication

import MainActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)

        //textView.text = count.toString()
        // textView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        button.setOnClickListener {
            // ++count
            // textView.text = count.toString()
            viewModel.updateCount()
            // textView.text = viewModel.count.toString()
        }
    }
}
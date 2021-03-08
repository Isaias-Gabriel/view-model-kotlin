package com.example.vmodelkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textCounter: EditText
    lateinit var buttonData: Button
    lateinit var buttonShow: Button

    lateinit var mainViewModel: MainViewModel

    var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initClick()
    }

    private fun initData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textCounter = findViewById<EditText>(R.id.textCounter)
        buttonData = findViewById<Button>(R.id.buttonData)
        buttonShow = findViewById<Button>(R.id.buttonShow)

        mainViewModel.mainCounter.observe(this, Observer { value ->
            textCounter.setText(value)
        })
    }
    
    private fun validateCounter() {
        if(counter > 7) {
            counter = 0
        }
    }

    private fun initClick() {
        buttonData.setOnClickListener {
            counter++
            validateCounter()
        }

        buttonShow.setOnClickListener {
            Toast.makeText(this, "Counter value: ${counter.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        logCycle(value = "onStart")

        super.onStart()
    }

    override fun onResume() {
        logCycle(value = "onResume")

        super.onResume()
    }

    override fun onPause() {
        logCycle(value = "onPause")

        super.onPause()
    }

    override fun onStop() {
        logCycle(value = "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        logCycle(value = "onDestroy")

        super.onDestroy()
    }

    private fun logCycle(tag: String = "Lifecycle", value: String) {
        Log.d(tag, value)
    }
}
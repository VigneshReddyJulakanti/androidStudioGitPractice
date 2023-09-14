package com.example.sevicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sevicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ServiceIntent= Intent(this,MyBackGroundService::class.java)

//        sending data to backgroundService
        ServiceIntent.putExtra("Name","Vigensh")
        binding.btStart.setOnClickListener {
            Log.i(MyBackGroundService.MyTag,"Start Button clicked")
            startService(ServiceIntent);
        }

        binding.btStop.setOnClickListener {
            Log.i(MyBackGroundService.MyTag,"Stop Button clicked")

            stopService(ServiceIntent);

        }
    }
}
package com.example.stopwatch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.stopwatch.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private var isStarted=false
    private lateinit var binding:ActivityMainBinding;
    private lateinit var ServiceIntent:Intent
    private  var time=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.btnStart.setOnClickListener {
            StartOrStop()
        }

        binding.btnReset.setOnClickListener {
            Reset()
        }

        ServiceIntent=Intent(applicationContext,StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UpdatedTime))


    }

    private fun StartOrStop(){
        if(isStarted){
            Stop()
        }else{
            Start()
        }
    }
    private fun Start(){

            isStarted=true
            binding.btnStart.text="Stop";
        ServiceIntent.putExtra(StopWatchService.CurrentTime,time)
        startService(ServiceIntent)

    }



    private fun Reset(){
        Stop()
        time = 0.0
        binding.textView.text = getFormattedTime(time)
    }
    private fun Stop(){
        isStarted=false
        binding.btnStart.text="Start"
        stopService(ServiceIntent)
    }

    private fun getFormattedTime(time:Double):String{
        val timeInt = time.roundToInt()
        val hours = timeInt % 86400 / 3600
        val minutes = timeInt % 86400 % 3600 / 60
        val seconds = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d",hours,minutes,seconds)
    }

    private val updateTime :BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            time=intent.getDoubleExtra(StopWatchService.CurrentTime,0.0);
            binding.textView.text=getFormattedTime(time)
        }

    }

}
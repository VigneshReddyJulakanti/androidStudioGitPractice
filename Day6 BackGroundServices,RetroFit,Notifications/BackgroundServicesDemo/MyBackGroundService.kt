package com.example.sevicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyBackGroundService : Service(){
    init {
        Log.i(MyTag,"Service Created");
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(MyTag,"Service Started")
        val MyName=intent?.getStringExtra("Name")
        Log.i(MyTag,"$MyName")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MyTag,"Service Destroying")
    }
    override fun onBind(intent: Intent?): IBinder? =null;

    companion object {
        const val MyTag="MYTag"
    }
}


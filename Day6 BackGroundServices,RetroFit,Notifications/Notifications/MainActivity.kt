package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    private val ChannelId ="package com.example.notifications.channel1"
    private var notificationManager:NotificationManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if(BuildConfig.DEBUG)
//            StrictMode.enableDefaults();
//
            notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(ChannelId,"Demo Channel","this is a demo")

         val button=findViewById<Button>(R.id.button);

        button.setOnClickListener{
            displayNotification()
        }

    }
    //    private fun DisplayNotification(){
    ////        Any int
    //        Log.i("Mytag","Ïn DisplayNotification")
    //            val notificationId=45
    //           val notification=NotificationCompat.Builder(this@MainActivity,ChannelId)
    //               .setContentTitle("Hurray")
    //               .setContentText("You did it")
    //               .setSmallIcon(android.R.drawable.ic_dialog_info)
    //               .setAutoCancel(true)
    //               .setPriority(NotificationCompat.PRIORITY_HIGH)
    //               .build()
    //        notificationManager?.notify(notificationId,notification)
    //    }

//    private fun createNotificationChannel(id:String,name:String,channelDescription:String){
//
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
//        {
//            val importance=NotificationManager.IMPORTANCE_HIGH
//            val channel=NotificationChannel(id,name,importance) .apply {
//                description=channelDescription
//            }
//            notificationManager?.createNotificationChannel(channel)
//        }
//
//    }

    private fun displayNotification(){
        Log.i("MyTag","display start")

        val notificationId = 45
        val notification = NotificationCompat.Builder(applicationContext,ChannelId)
            .setContentTitle("Demo Title")
            .setContentText("This is a demo notification")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        notificationManager?.notify(notificationId,notification)
        Log.i("MyTag","display end")
    }
    private fun createNotificationChannel(id : String, name:String, channelDescription:String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("MyTag","succesfully creating notification")
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
            Log.i("MyTag","succesfully ending notification")

        }
    }
}
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CarActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car3)

        val car1= Car("Bugati");
        car1.start();

        val driver1=Driver("MrBoom");
        driver1.showDetails();
        Log.i("My_Tag",driver1.DriverName);
        driver1.DriverName="Bam";
        Log.i("My_Tag",driver1.DriverName);

    }
}
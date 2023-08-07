package com.example.myapplication

import android.util.Log

class Driver(name :String) {

    var DriverName="";

    val c1=Car("Benz");

    init{
        DriverName=name;
    }

    fun showDetails(){
        Log.i("My_tag","Driver name is $DriverName and car is ${c1.carName}");
    }
}
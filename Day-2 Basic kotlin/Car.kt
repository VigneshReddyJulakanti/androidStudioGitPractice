package com.example.myapplication

import android.util.Log

class Car(name :String) {
    var carName="";
    val speed=50;
    init{
        carName=name;
    }
    fun start(){
        Log.i("My_tag","$carName is Starting with speed $speed");
    }
}
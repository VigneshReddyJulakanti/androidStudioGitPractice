package com.example.myapplication

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText;
    private lateinit var age:EditText;
    private lateinit var sf:SharedPreferences;
    private lateinit var editor:SharedPreferences.Editor;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.etName);
        age=findViewById(R.id.etAge);

        sf=getSharedPreferences("my_sf", MODE_PRIVATE);
        editor=sf.edit();
    }

    override fun onPause() {
        Log.i("My_tag","MainActivity:OnPause");
        super.onPause()
        val tname=name.text.toString();
        val tage=age.text.toString().toInt();
        editor.apply{
            putString("sf_name",tname);
            putInt("sf_age",tage);
            commit()
        }

    }

    override fun onResume() {
        Log.i("My_tag","MainActivity:OnResume");

        super.onResume();
        val tname=sf.getString("sf_name",null);
        val tage=sf.getInt("sf_age",0);

        if(tage!=0){
            age.setText(tage.toString());
        }
        name.setText(tname);

    }
}
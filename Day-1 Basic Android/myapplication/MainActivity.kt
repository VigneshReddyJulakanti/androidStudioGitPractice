package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hello=findViewById<TextView>(R.id.hello);
        val name=findViewById<EditText>(R.id.name);
        val submit=findViewById<Button>(R.id.submit);
        val move=findViewById<Button>(R.id.btnNextPage);
        var temp="";
        submit.setOnClickListener{
            
            
             temp=name.text.toString();

            if(temp == ""){
                move.visibility= INVISIBLE;
                Toast.makeText(this@MainActivity, "Enter Valid String", Toast.LENGTH_SHORT).show()
            }else {
                val newtemp = "Hello $temp";
                hello.text = newtemp;
                name.text.clear();
                move.visibility=VISIBLE;
            }
        }

        move.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("NameUser",temp);
            startActivity(intent);
        }

    }
}
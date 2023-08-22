package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animals= listOf<animalclass>(animalclass("gira","Lion"),animalclass("Ele","cockro"),animalclass("bull","snail"),animalclass("zeb","vignesh"));

        val myRecyclerview=findViewById<RecyclerView>(R.id.MyRecyerview);
        myRecyclerview.setBackgroundColor(Color.RED);
        myRecyclerview.layoutManager=LinearLayoutManager(this)
        myRecyclerview.adapter=MyRecycleViewAdaptar(animals,
            {
                selectedItem:animalclass ->
                ListItemClicked(selectedItem);
            }
            );


    }


    private  fun ListItemClicked(animal:animalclass){
        Toast.makeText(this,"updated name is ${animal.name} last is ${animal.lastname}", Toast.LENGTH_LONG).show()

    }
}
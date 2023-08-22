package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyRecycleViewAdaptar(
    private val animals:List<animalclass>,
    private val clickListener: (animalclass)->Unit

    ) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context);
        val listItem=layoutInflater.inflate(R.layout.list_item,parent,false);
        return MyViewHolder(listItem);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(animals[position],clickListener)
    }

    override fun getItemCount(): Int {
        return animals.size;
    }
}

class MyViewHolder(val view:View):RecyclerView.ViewHolder(view){

    fun bind(animal:animalclass,clickListener: (animalclass)->Unit){
        val myTextView=view.findViewById<TextView>(R.id.LiTextView);
        myTextView.text=animal.name+" "+animal.lastname;

        view.setOnClickListener{
           clickListener(animal)

        }

    }

}
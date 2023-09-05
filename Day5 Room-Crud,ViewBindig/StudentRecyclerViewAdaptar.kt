package com.example.roomcrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcrud.databinding.ListitemBinding
import com.example.roomcrud.db.Student

class StudentRecyclerViewAdaptar(private val StudentClickHandler:(Student)->Unit):RecyclerView.Adapter<StudentViewHolder>() {

    private val studentList=ArrayList<Student>();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val layoutInflater =LayoutInflater.from(parent.context);
//        val listItemI=layoutInflater.inflate(R.layout.listitem,parent,false);
        val binding =ListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return StudentViewHolder(binding);
    }


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],StudentClickHandler);
    }

    override fun getItemCount(): Int {
        return studentList.size;
        }

    fun setList(students:List<Student>){
        studentList.clear();
        studentList.addAll(students);
    }
}

class StudentViewHolder(private val binding:ListitemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(student:Student,StudentClickHandler:(Student)->Unit){
//        val tvname=view.findViewById<TextView>(R.id.tvName);
//        val tvemail=view.findViewById<TextView>(R.id.tvEmail);
        binding.tvName.text=student.name;
        binding.tvEmail.text=student.email;

        binding.root.setOnClickListener{
            StudentClickHandler(student)
        }
    }
}
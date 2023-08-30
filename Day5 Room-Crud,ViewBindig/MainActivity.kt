package com.example.roomcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcrud.db.Student
import com.example.roomcrud.db.StudentDao
import com.example.roomcrud.db.StudentDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var etName:EditText;
    private lateinit var etMail:EditText;
    private lateinit var btSave:Button;
    private lateinit var btClear:Button;
    private lateinit var rvStudent:RecyclerView;
    private lateinit var adaptar: StudentRecyclerViewAdaptar;
    private lateinit var selectedStudent:Student;
    private var editMode=false;


    private lateinit var viewModel: StudentViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName=findViewById(R.id.etName);
        etMail=findViewById(R.id.etEmail);
        btSave=findViewById(R.id.btSave);
        btClear=findViewById(R.id.btClear);

        rvStudent=findViewById(R.id.rvStudent);

        val dao=StudentDatabase.getInstance(application).studentDao();

        val factory=StudentViewModelFactory(dao);

        viewModel=ViewModelProvider(this,factory).get(StudentViewModel::class.java);


        btSave.setOnClickListener{

            if (editMode==false) {
            saveStudentData();
            }else {

                viewModel.updateStudent(
                    Student(

                        selectedStudent.id,
                        etName.text.toString(),
                        etMail.text.toString()
                    )
                )
                editMode=false;
                btSave.text="Save";
                btClear.text="Clear";
            }
            clearInput();
        }

        btClear.setOnClickListener{

            if (editMode) {

                viewModel.deleteStudent(selectedStudent);
                editMode=false;
                btSave.text="Save";
                btClear.text="Clear";

            }
            clearInput();
        }

        initRecyclerView();
    }


    private fun saveStudentData(){
//        val name=etName.text.toString();
//        val email=etMail.text.toString();
//
//        val student=Student(0,name,email);
//        viewModel.insertStudent(student);
//        or


            viewModel.insertStudent(
                Student(
                    0,
                    etName.text.toString(),
                    etMail.text.toString()
                )
            )


    }

    private fun clearInput(){


            etName.setText("");
            etMail.setText("");

    }

    private fun initRecyclerView(){
        rvStudent.layoutManager=LinearLayoutManager(this);
        adaptar=StudentRecyclerViewAdaptar{
            listItemClicked(it);
        };
        rvStudent.adapter=adaptar;

        displayStudentList();
    }

    private fun displayStudentList(){
        viewModel.students.observe(this,{
            adaptar.setList(it);
            adaptar.notifyDataSetChanged();
        })
    }

    private fun listItemClicked(student:Student){
        selectedStudent=student;
        editMode=true;
        btSave.text="Update";
        btClear.text="Delete";
        etMail.setText(student.email);
        etName.setText(student.name);
//        Toast.makeText(this,"student ${student.name}",Toast.LENGTH_LONG).show();
    }
}

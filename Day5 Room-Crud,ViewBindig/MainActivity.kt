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
import com.example.roomcrud.databinding.ActivityMainBinding
import com.example.roomcrud.db.Student
import com.example.roomcrud.db.StudentDao
import com.example.roomcrud.db.StudentDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
//    private lateinit var etName:EditText;
//    private lateinit var etMail:EditText;
//    private lateinit var btSave:Button;
//    private lateinit var btClear:Button;
//    private lateinit var rvStudent:RecyclerView;
    private lateinit var adaptar: StudentRecyclerViewAdaptar;
    private lateinit var selectedStudent:Student;
    private var editMode=false;


    private lateinit var viewModel: StudentViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        etName=findViewById(R.id.etName);
//        etMail=findViewById(R.id.etEmail);
//        btSave=findViewById(R.id.btSave);
//        btClear=findViewById(R.id.btClear);

//        rvStudent=findViewById(R.id.rvStudent);

        val dao=StudentDatabase.getInstance(application).studentDao();

        val factory=StudentViewModelFactory(dao);

        viewModel=ViewModelProvider(this,factory).get(StudentViewModel::class.java);


        binding.btSave.setOnClickListener{

            if (editMode==false) {
            saveStudentData();
            }else {

                viewModel.updateStudent(
                    Student(

                        selectedStudent.id,
                        binding.etName.text.toString(),
                        binding.etEmail.text.toString()
                    )
                )
                editMode=false;
                binding.btSave.text="Save";
                binding.btClear.text="Clear";
            }
            clearInput();
        }

        binding.btClear.setOnClickListener{

            if (editMode) {

                viewModel.deleteStudent(selectedStudent);
                editMode=false;
                binding.btSave.text="Save";
                binding.btClear.text="Clear";

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
                    binding.etName.text.toString(),
                    binding.etEmail.text.toString()
                )
            )


    }

    private fun clearInput(){


        binding.etName.setText("");
        binding.etEmail.setText("");

    }

    private fun initRecyclerView(){
        binding.rvStudent.layoutManager=LinearLayoutManager(this);
        adaptar=StudentRecyclerViewAdaptar{
            listItemClicked(it);
        };
        binding.rvStudent.adapter=adaptar;

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
        binding.btSave.text="Update";
        binding.btClear.text="Delete";
        binding.etEmail.setText(student.email);
        binding.etName.setText(student.name);
//        Toast.makeText(this,"student ${student.name}",Toast.LENGTH_LONG).show();
    }
}

package com.example.roomcrud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Student_Id")
    val id:Int,

    @ColumnInfo(name="Student_name")
    val name:String ,


    val email:String

                   )

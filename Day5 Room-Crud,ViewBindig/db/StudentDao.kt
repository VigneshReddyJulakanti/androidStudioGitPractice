package com.example.roomcrud.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student:Student)

    @Delete
    suspend fun deleteStudent(student:Student)

    @Query("select * from student_table")
    fun getAllStudents():LiveData<List<Student>>
}
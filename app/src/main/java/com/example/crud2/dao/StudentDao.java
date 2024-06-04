package com.example.crud2.dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.crud2.Entity.Student;
import static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;
@Dao
public interface StudentDao {
    @Insert(onConflict = REPLACE)
    Void insert(Student student);

    @Query("Update Student SET Studname=:Sname,StudEmail=:Semail,StudPhone=:Sphone,StudAddress=:Saddress,StudDepartment=:Sdepartment where studRoll=:Sroll")
    void update(int Sroll,String Sname,String Semail,String Sphone,String Saddress,String Sdepartment);

//    @Update
//    void updateData(Student student);

    @Delete
    void delete(Student student);


    @Query("Select*from Student")
    List<Student> getAll();
}

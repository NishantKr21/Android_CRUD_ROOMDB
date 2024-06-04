package com.example.crud2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.crud2.Entity.Student;
import com.example.crud2.dao.StudentDao;

@Database(entities = Student.class,version=1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {

    private static StudentDataBase database;

    public synchronized static StudentDataBase getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),StudentDataBase.class,"CRUD").allowMainThreadQueries().
                    fallbackToDestructiveMigration().build();
        }
        return database;
    }
    public abstract StudentDao studentDao();
}

package com.example.crud2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.crud2.Entity.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText Roll,Name,Email,Phone,Address,Department;
    Button Save,Show,Delete,Update;
    List<Student> StudentList;
    private Context context;
    StudentDataBase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        context=MainActivity.this;

        Roll=findViewById(R.id.editTextText);
        Name=findViewById(R.id.editTextText2);
        Email=findViewById(R.id.editTextText3);
        Phone=findViewById(R.id.editTextText4);
        Address=findViewById(R.id.editTextText5);
        Department=findViewById(R.id.editTextText6);

        Save=findViewById(R.id.button);
        Show=findViewById(R.id.button2);
        Delete=findViewById(R.id.button4);
        Update=findViewById(R.id.button3);

        database= StudentDataBase.getInstance(context);
        StudentList=database.studentDao().getAll();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Roll.getText().length()==0||Name.getText().length()==0||Email.getText().length()==0||Phone.getText().length()==0||
                Address.getText().length()==0||Department.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Please Fill the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Student student=new Student();
                    student.setName(Name.getText().toString());
                    student.setEmail(Email.getText().toString());
                    student.setPhone(Phone.getText().toString());
                    student.setAddress(Address.getText().toString());
                    student.setDepartment(Department.getText().toString());
                    database.studentDao().insert(student);
                    Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    listUpdate();

                }
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Roll.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Fill Roll number", Toast.LENGTH_SHORT).show();
                }
                else{
                    int deleteRoll=Integer.parseInt(Roll.getText().toString());
                    Student DelStudent=null;
                    for(Student s:StudentList){
                        if(s.getRoll()==deleteRoll){
                            DelStudent=s;
                            break;
                        }
                    }
                    if(DelStudent==null){
                        Toast.makeText(MainActivity.this, "No Students There", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        database.studentDao().delete(DelStudent);
                        Toast.makeText(MainActivity.this, "Deleted SuccessFully", Toast.LENGTH_SHORT).show();
                        listUpdate();
                    }
                }

            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Roll.getText().length()==0||Name.getText().length()==0||Email.getText().length()==0||Phone.getText().length()==0||
                        Address.getText().length()==0||Department.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Please Fill the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    int updateRoll=Integer.parseInt(Roll.getText().toString());
                    boolean isThere=false;
                    for(Student s:StudentList){
                        if(s.getRoll()==updateRoll){
                            isThere=true;
                            break;
                        }
                    }
                    if(isThere==true){
                        String name1=Name.getText().toString();
                        String email1=Email.getText().toString();
                        String phone1=Phone.getText().toString();
                        String address1=Address.getText().toString();
                        String Department1=Department.getText().toString();
                        database.studentDao().update(updateRoll,name1,email1,phone1,address1,Department1);
                        Toast.makeText(MainActivity.this, "Updated SuccessFully", Toast.LENGTH_SHORT).show();
                        listUpdate();

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Roll is Not There", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder st=new StringBuilder();
                for(Student s:StudentList){
                    st.append(s.getRoll()+", "+s.getName()+", "+s.getEmail()+", "+s.getPhone()+", "+s.getAddress()+", "+s.getDepartment());
                    st.append("\n");
                }
                String finalData=st.toString();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("key",finalData);
                startActivity(intent);
            }
        });



    }
    private void listUpdate(){
        StudentList.clear();
        StudentList.addAll(database.studentDao().getAll());
    }
}
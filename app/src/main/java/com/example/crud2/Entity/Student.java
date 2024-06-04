package com.example.crud2.Entity;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity

public class Student {
    @ColumnInfo(name = "StudRoll")
    @PrimaryKey(autoGenerate = true)
    int Roll;
    @ColumnInfo(name = "StudName")
    String Name;
    @ColumnInfo(name = "StudEmail")
    String Email;
    @ColumnInfo(name = "StudPhone")
    String Phone;
    @ColumnInfo(name = "StudAddress")
    String Address;
    @ColumnInfo(name = "StudDepartment")
    String  Department;


    public int getRoll() {
        return Roll;
    }

    public void setRoll(int roll) {
        Roll = roll;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}

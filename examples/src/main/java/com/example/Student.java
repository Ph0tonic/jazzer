package com.example;

import java.io.*;

public class Student implements Serializable{
  public Student(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public String toString() {
    return "name: "+name+"\nage: "+String.valueOf(age);
  }

  public String name = "";
  public Integer age = 0;
}
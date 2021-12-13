package com.example;

import java.io.*; 

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
// import com.code_intelligence.jazzer.api.autofuzz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.lang.Runtime;
import java.lang.Process;

public class BuilderFuzzer {

  public static int count = 0;
  public static void fuzzerTestOneInput(FuzzedDataProvider data) throws Exception {

    String className = "com.example.Student";
    Class<?> targetClass = Student.class;
    try {
      // Explicitly invoking static initializers to trigger some coverage in the code.
      targetClass = Class.forName(className, true, ClassLoader.getSystemClassLoader());
    } catch (ClassNotFoundException e) {
      System.err.printf(
        "Failed to find class %s for autofuzz, please ensure it is contained in the classpath "
            + "specified with --cp and specify the full package name%n",
            className);
      e.printStackTrace();
      System.exit(1);
      return;
    }

    // int i1 = (int)Builder.build(data, int.class);
    // int i2 = (int)Builder.build(data, int.class);
    // System.out.println("Get new int : " +String.valueOf(i1+i2));
    
    // String s = (String)Builder.build(data, String.class);
    // System.out.println("Get new String : " + s);
    count++;
    Builder.prebuiltObjects.put(String.class, new String[]{"Jason Hood", "Patrick Jester"});
    
    Student student = (Student)Builder.build(data, Student.class);
    // System.out.println("Get new Student : " + (student == null ? "null" : "not null"));
    System.out.println("Get new Student : " + student.toString());
    // throw new Exception("Get new int : " + String.valueOf(i1));

    if (count > 100){
      System.exit(1);
    }
  }
}


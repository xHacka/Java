package com.example.lecture2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSingleton {
    private static StudentSingleton instance;

    public final List<Student> students = new ArrayList<Student>();

    private StudentSingleton() { }

    public static StudentSingleton getInstance() {
        if (instance == null) { instance = new StudentSingleton(); }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }
}

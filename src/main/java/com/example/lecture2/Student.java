package com.example.lecture2;

public class Student {
    private String name, lastname;
    private Integer age;

    public Student(String name, String lastname, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public static Student[] getDummyData(int limit) {
        Student[] students = new Student[limit];
        for (int i = 0; i < limit; i++) {
            students[i] = new Student(
                    String.format("name%d", i + 1),
                    String.format("lastname%d", i + 1),
                    20 + i
            );
        }
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', lastname='%s', age=%d}", name, lastname, age);
    }
}

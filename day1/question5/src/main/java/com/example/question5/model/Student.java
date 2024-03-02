package com.example.question5.model;

public class Student {
    private String name;
    private int roolno;
    public Student(String name, int roolno) {
        this.name = name;
        this.roolno = roolno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRoolno() {
        return roolno;
    }
    public void setRoolno(int roolno) {
        this.roolno = roolno;
    }
}

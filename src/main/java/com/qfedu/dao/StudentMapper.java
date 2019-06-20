package com.qfedu.dao;

import com.qfedu.pojo.Student;

import java.util.List;


public interface StudentMapper {
    List<Student> studentList();

    void addStus(List<Student> studentList);

    void gradedelete(String no);

    void studentadd(Student student);
}

package com.qfedu.service;

import com.qfedu.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map<String,Object> studentList(Integer page, Integer limit);

    void addStus(List<Student> studentList);

    void gradedelete(String no);

    void studentadd(Student student);
}

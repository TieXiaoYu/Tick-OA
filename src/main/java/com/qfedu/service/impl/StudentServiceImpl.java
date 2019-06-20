package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.StudentMapper;
import com.qfedu.pojo.Student;
import com.qfedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String, Object> studentList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Student> list =studentMapper.studentList();
        System.out.println(list+"1111111111111111");
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        // map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return  map;
    }

    @Override
    public void addStus(List<Student> studentList) {
        studentMapper.addStus(studentList);
    }

    @Override
    public void gradedelete(String no) {
        studentMapper.gradedelete(no);
    }

    @Override
    public void studentadd(Student student) {
        student.setFlag(1);
        studentMapper.studentadd(student);
    }

}

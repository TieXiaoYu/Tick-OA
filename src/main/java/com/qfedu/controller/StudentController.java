package com.qfedu.controller;

import com.qfedu.pojo.Grade;
import com.qfedu.pojo.Student;
import com.qfedu.service.GradeService;
import com.qfedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/studentList")
    @ResponseBody
    public Map<String,Object> studentList(Integer page, Integer limit){

        Map<String,Object> map= studentService.studentList(page,limit);
        return map;
    }

    @RequestMapping(value = "/studentdelete")
    @ResponseBody
    public Map<String, Object> studentdelete(String no){
        studentService.gradedelete(no);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        return map;
    }

    @RequestMapping(value = "/gradeall")
    @ResponseBody
    public List<Grade> gradeall(){
        List<Grade> list=  gradeService.gradeall();
        return  list;
    }
    @RequestMapping(value = "/studentadd")
    public String studentadd(Student student){
        studentService.studentadd(student);

         return "redirect:/studentlist.html";

    }

}

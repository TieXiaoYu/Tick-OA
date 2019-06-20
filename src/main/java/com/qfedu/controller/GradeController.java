package com.qfedu.controller;

import com.qfedu.pojo.Course;
import com.qfedu.pojo.Grade;
import com.qfedu.service.CourseService;
import com.qfedu.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;


    @RequestMapping("/gradeList")
    @ResponseBody
    public Map<String, Object> gradeList(Integer page, Integer limit) {
        Map<String, Object> map = gradeService.gradeList(page, limit);
        return map;
    }

    @RequestMapping("/gradedelete")
    @ResponseBody
    public Map<String, Object> gradedelete(Integer id){
        gradeService.gradedelete(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        return map;
    }

    @RequestMapping("/gradeupdate")

    public String courseUpdate(Grade grade){
        gradeService.gradeUpdate(grade);
        return "redirect:/gradelist.html";
    }

    @RequestMapping("/courseall")
    @ResponseBody
    public List<Course> courseall(){
      List<Course> list=  courseService.courseAll();
        return  list;
    }
    @RequestMapping("/gradeadd")
      public String gradeadd(Grade grade){
              gradeService.gradeadd(grade);
        return "redirect:/gradelist.html";
    }

}

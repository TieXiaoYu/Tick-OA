package com.qfedu.controller;

import com.qfedu.pojo.Course;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courseList")
     @ResponseBody
     public Map<String,Object> courseList(Integer page, Integer limit){

      Map<String,Object> map= courseService.courseList(page,limit);
        return map;
     }

    @RequestMapping(value = "/courseDelete")
    @ResponseBody
    public Map<String,Object> courseDelete(Integer id){
        courseService.courseDelete(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        return map;
    }

    @RequestMapping(value = "/courseUpdate" )

    public String courseUpdate(Course course){
           courseService.courseUpdate(course);
        return "redirect:/courselist.html";
    }
    @RequestMapping(value = "/courseAdd")

    public String courseAdd(Course course){
        courseService.courseAdd(course);

        return "redirect:/courselist.html";
    }

}

package com.qfedu.service;

import com.qfedu.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    Map<String,Object>  courseList(Integer page, Integer limit);

    void courseDelete(Integer id);

    void courseUpdate(Course course);

    void courseAdd(Course course);

     List<Course> courseAll();

}

package com.qfedu.dao;

import com.qfedu.pojo.Course;

import java.util.List;


public interface CourseMapper {
    List<Course> courseList();

    void courseDelete(Integer id);

    void courseUpdate(Course course);

    void courseAdd(Course course);
}

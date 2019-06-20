package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseMapper;
import com.qfedu.pojo.Course;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Map<String,Object> courseList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Course> list = courseMapper.courseList();

        long total = ((Page) list).getTotal();
        int pages = ((Page) list).getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
       // map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    @Override
    public void courseDelete(Integer id) {
        courseMapper.courseDelete(id);
    }

    @Override
    public void courseUpdate(Course course) {
           if(course.getType().getTname().equals("GP")){
               course.setTypeId(2);
           }else if (course.getType().getTname().equals("混合")){
               course.setTypeId(3);
           }else {
               course.setTypeId(1);
           }
        courseMapper.courseUpdate(course);
    }

    @Override
    public void courseAdd(Course course) {
         course.setFlag(1);
             courseMapper.courseAdd(course);
    }

    @Override
    public List<Course> courseAll() {
        List<Course> list = courseMapper.courseList();
        return list;
    }
}

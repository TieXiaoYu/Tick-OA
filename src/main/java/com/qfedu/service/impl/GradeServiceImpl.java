package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.GradeMapper;
import com.qfedu.pojo.Grade;
import com.qfedu.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {


    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public Map<String,Object> gradeList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Grade> list =gradeMapper.gradeList();
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
    public void gradedelete(Integer id) {
        gradeMapper.gradedelete(id);
    }



    @Override
    public void gradeUpdate(Grade grade) {
        gradeMapper.gradeUpdate(grade);
    }

    @Override
    public void gradeadd(Grade grade) {
        grade.setFlag(1);
        grade.setCount(50);
        gradeMapper.gradeadd(grade);
    }

    @Override
    public List<Grade> gradeall() {

        return  gradeMapper.gradeList();
    }


}

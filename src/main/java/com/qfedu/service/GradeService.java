package com.qfedu.service;

import com.qfedu.pojo.Grade;

import java.util.List;
import java.util.Map;


public interface GradeService {
    Map<String,Object> gradeList(Integer page, Integer limit);

    void gradedelete(Integer id);



    void gradeUpdate(Grade grade);

    void gradeadd(Grade grade);

    List<Grade> gradeall();
}

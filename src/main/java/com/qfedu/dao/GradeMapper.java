package com.qfedu.dao;

import com.qfedu.pojo.Grade;

import java.util.List;

public interface GradeMapper {
    List<Grade> gradeList();

    void gradedelete(Integer id);

    void gradeUpdate(Grade grade);

    void gradeadd(Grade grade);


}
package com.qfedu.dao;

import com.qfedu.pojo.EmpThings;
import com.qfedu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmpDao{


    List<EmpThings> findAll(@Param("flag") String flag);

    void processUpdate(@Param("id") String id, @Param("flag") String flag);

    List<User> departAll();

    void processAdd(EmpThings empThings);
}

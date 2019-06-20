package com.qfedu.service;

import com.qfedu.pojo.EmpThings;
import com.qfedu.pojo.User;

import java.util.List;
import java.util.Map;

public interface EmpService {

    Map<String,Object> findThinsList(Integer page, Integer limit, String flag);

    void processUpdate(String id, String flag);

    List<User> departAll();

    void processAdd(EmpThings empThings);

    /*Map<String,Object> findThingsByPid(String pid);*/
}

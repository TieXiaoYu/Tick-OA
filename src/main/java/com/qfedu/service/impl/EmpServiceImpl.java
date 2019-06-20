package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.EmpDao;
import com.qfedu.pojo.EmpThings;
import com.qfedu.pojo.User;
import com.qfedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired(required = false)
    private EmpDao empDao;

    @Override
    public Map<String, Object> findThinsList(Integer page, Integer limit,String flag) {

        PageHelper.startPage(page,limit);
        List<EmpThings> list = empDao.findAll(flag);

        long total = ((Page) list).getTotal();
        Map<String ,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);


        return map;
    }

    @Override
    public void processUpdate(String id, String flag) {
        empDao.processUpdate(id,flag);
    }

    @Override
    public List<User> departAll() {
        return empDao.departAll();
    }

    @Override
    public void processAdd(EmpThings empThings) {
        empDao.processAdd(empThings);
    }

    /*@Override
    public Map<String, Object> findThingsByPid(String pid) {

        empDao.findAll()


        return null;
    }*/
}

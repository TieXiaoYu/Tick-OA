package com.qfedu.controller;

import com.qfedu.pojo.EmpThings;
import com.qfedu.pojo.User;
import com.qfedu.service.EmpService;
import com.qfedu.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpThingController {

    @Autowired(required = false)
    private EmpService empService;

    @RequestMapping("/processlist.do")
    @ResponseBody
    public Map<String ,Object> loginloglist(Integer page, Integer limit,String flag){

        Map<String, Object> map = empService.findThinsList(page, limit, flag);

        return map;
    }

    @RequestMapping("/processnolist.do")
    @ResponseBody
    public Map<String ,Object> loginloglist2(Integer page, Integer limit,String flag){

        Map<String, Object> map = empService.findThinsList(page, limit,flag);

        return map;
    }

    @RequestMapping("/processupdate.do")
    @ResponseBody
    public JsonBean processUpdate(String id, String flag){

        empService.processUpdate(id,flag);

        return new JsonBean(1,"");
    }

    @RequestMapping("/departall.do")
    @ResponseBody
    public List<User> departAll(){

        List<User> list= empService.departAll();

        return list;
    }

    @RequestMapping("/processadd.do")
    public void processAdd(EmpThings empThings, HttpServletRequest request, HttpServletResponse response){

        empThings.setFlag(1);
        empService.processAdd(empThings);

        String contextPath = request.getContextPath();
        try {
            response.sendRedirect(contextPath+"/processtodolist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*@RequestMapping("/processecharts.do")
    @ResponseBody
    public Map<String ,Object> findThingsByPid(String pid){

        Map<String ,Object> map = empService.findThingsByPid(pid);

        return map;
    }*/
}

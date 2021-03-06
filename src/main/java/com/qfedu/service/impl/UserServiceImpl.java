package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.UserDao;
import com.qfedu.pojo.Authority;
import com.qfedu.pojo.LoginInfo;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.VoMenu;
import com.qfedu.vo.VoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<VoMenu> findPermsById(String id) {
        return userDao.findPermsByName(id);
    }

    @Override
    public void insert(LoginInfo loginInfo) {
        userDao.insert(loginInfo);
    }

    @Override
    public Map<String ,Object> findLogList(String id,Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<LoginInfo> logList = userDao.findLogList(id);

        long total = ((Page) logList).getTotal();

        Map<String ,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",logList);

        return map;
    }

    @Override
    public Map<String ,Object> findAll(Integer page, Integer limit,String no) {

        long total = 0;
        Map<String ,Object> map = new HashMap<>();
        Map<String ,VoUser> mapVo = new HashMap<>();
        PageHelper.startPage(page,limit);
        List<VoUser> list = userDao.findAll(no);

        total = ((Page) list).getTotal();

        List<VoUser> listVo = new ArrayList<>();


        if (list == null){
            map.put("code",0);
            map.put("msg","对不起，无该用户的信息");
            map.put("count",total);
            map.put("data",list);
            return map;
        }

        mapVo.put(list.get(0).getNo()+"",list.get(0));
        if (list.size() <= 1){
            listVo.add(mapVo.get(list.get(0).getNo()+""));
            map.put("code",0);
            map.put("msg","");
            map.put("count",total);
            map.put("data",listVo);
            return map;
        }

        for (int i = 1; i < list.size(); i++) {
            Set<String> key = mapVo.keySet();
            if (!key.contains(list.get(i).getNo())){
                mapVo.put(list.get(i).getNo()+"",list.get(i));
            }else {
                mapVo.get(list.get(i).getNo()).setRole(mapVo.get(list.get(i).getNo()).getRole()
                        +","+list.get(i).getRole());

                mapVo.get(list.get(i).getNo()).setRid(mapVo.get(list.get(i).getNo()).getRid()
                        +","+list.get(i).getRid());
            }
        }

        Set<String> key = mapVo.keySet();
        Iterator<String> iterator = key.iterator();
        while (iterator.hasNext()){
            listVo.add(mapVo.get(iterator.next().toString()));
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",listVo);

        return map;
    }

    @Override
    public List<Role> findAllRole() {
        return userDao.findAllRole();
    }

    @Override
    public void updateRole(Integer id, String[] rids) {

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < rids.length; i++) {
            map.put(rids[i],id);
        }

        userDao.delRole(id);
        userDao.updateRole(map);
    }

    @Override
    public void delUser(Integer id) {
        userDao.delUser(id);
        userDao.delRole(id);
    }

    @Override
    public Map<String, Object> findAllAuthority(Integer page, Integer limit) {

        Map<String ,Object> map = new HashMap<>();
        PageHelper.startPage(page,limit);
        List<Authority> list = userDao.findAllAuthority();

        long total = ((Page) list).getTotal();

        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);


        return map;
    }

    @Override
    public void updateAutho(Authority authority) {
        userDao.updateAutho(authority);
    }

    @Override
    public List<VoMenu> findAllParentAutho() {
        return userDao.findAllParentAutho();
    }

    @Override
    public void authorityAdd(Authority authority) {
        userDao.authorityAdd(authority);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false)
    public boolean findAuthorityById(String id) {

        Authority authority = userDao.chaAuthorityById(id);
        if(authority != null){
            if(authority.getParentId() == 0){
                List<Integer> list = userDao.chaAuthorityByParentId(id);
                userDao.delAuthorityById(id);
                userDao.delAuthorityByParentId(id);
                userDao.delRoleByAid(id);
                if (list.size() > 0){
                    userDao.delRoleByAidList(list);
                }
                return true;
            }else {
                userDao.delAuthorityById(id);
                userDao.delRoleByAid(id);
                return true;
            }
        }else {
            return false;
        }


    }

}

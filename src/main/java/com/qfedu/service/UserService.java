package com.qfedu.service;

import com.qfedu.pojo.Authority;
import com.qfedu.pojo.LoginInfo;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.vo.VoMenu;

import java.util.List;
import java.util.Map;


public interface UserService {

    User findByName(String name);

    List<VoMenu> findPermsById(String id);

    void insert(LoginInfo loginInfo);

    Map<String ,Object> findLogList(String id, Integer page, Integer limit);

    Map<String ,Object> findAll(Integer page, Integer limit, String no);

    List<Role> findAllRole();

    void updateRole(Integer id, String[] ids);

    void delUser(Integer id);

    Map<String,Object> findAllAuthority(Integer page, Integer limit);

    void updateAutho(Authority authority);

    List<VoMenu> findAllParentAutho();

    void authorityAdd(Authority authority);

    boolean findAuthorityById(String id);
}

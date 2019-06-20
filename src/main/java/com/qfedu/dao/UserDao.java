package com.qfedu.dao;

import com.qfedu.pojo.Authority;
import com.qfedu.pojo.LoginInfo;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.vo.VoMenu;
import com.qfedu.vo.VoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao {


    List<String> findRolesByName(String name);

    List<VoMenu> findPermsByName(@Param("id") String id);

    User findByName(String name);

    void insert(LoginInfo loginInfo);

    List<LoginInfo> findLogList(String id);

    List<VoUser> findAll(@Param("no") String no);

    List<Role> findAllRole();

    void updateRole(@Param("params") Map<String, Integer> map);

    void delRole(Integer id);

    void delUser(Integer id);

    List<Authority> findAllAuthority();

    void updateAutho(Authority authority);

    List<VoMenu> findAllParentAutho();

    void authorityAdd(Authority authority);

    Authority chaAuthorityById(String id);

    void delAuthorityByParentId(String id);

    void delAuthorityById(String id);

    List<Integer> chaAuthorityByParentId(String id);

    void delRoleByAidList(@Param("list") List<Integer> list);

    void delRoleByAid(String id);
}

package com.qfedu.controller;

import com.qfedu.pojo.Authority;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.VoMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonBean login(String no, String pass, String ip, String city, HttpServletRequest request, HttpServletResponse response){

        User user = userService.findByName(no);
        if (user != null){
            if (user.getNo().equals(no)
                    && user.getPassword().equals(pass)){
                if (user.getFlag() == '1'){
                    HttpSession session = request.getSession();
                    session.setAttribute("userInfo",user.getName());
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(60*60);
                    cookie.setPath("/oasys");
                    response.addCookie(cookie);
                    return new JsonBean(1,user);
                }else {
                    return new JsonBean(0,"登陆失败，该账号已被冻结");
                }
            }else {
                return new JsonBean(0,"用户名或密码不正确,请重试");
            }
        }else {
            return new JsonBean(0,"登陆失败，该账号不存在");
        }
    }

    @RequestMapping("/findPerms.do")
    @ResponseBody
    public JsonBean listPerms(String id){

        List<VoMenu> list = userService.findPermsById(id);

        return new JsonBean(1,list);
    }

    @RequestMapping("/loginloglist.do")
    @ResponseBody
    public Map<String ,Object> loginLogList(String id, Integer page, Integer limit){

        Map<String, Object> logList = userService.findLogList(id, page, limit);

        return logList;
    }

    @RequestMapping("/userall.do")
    @ResponseBody
    public Map<String ,Object> userAll(Integer page, Integer limit,String no){

        Map<String ,Object> map = userService.findAll(page,limit,no);

        return map;
    }

    @RequestMapping("/roleall.do")
    @ResponseBody
    public List<Role> roleAll(){

        List<Role> list = userService.findAllRole();

        return list;
    }

    @RequestMapping("/userroleedit.do")
    @ResponseBody
    public JsonBean userRoleEdit(Integer id,String[] rids){

        userService.updateRole(id,rids);

        return new JsonBean(1000,null);
    }

    @RequestMapping("/userdel.do")
    @ResponseBody
    public JsonBean userDel(Integer id){

        userService.delUser(id);

        return new JsonBean(1000,null);
    }

    @RequestMapping("/authoritylist.do")
    @ResponseBody
    public Map<String ,Object> authorityList(Integer page,Integer limit){

        Map<String ,Object> map = userService.findAllAuthority(page,limit);

        return map;
    }

    @RequestMapping("/authorityupdate.do")
    @ResponseBody
    public JsonBean authorityUpdate(Authority authority){

        try {
            userService.updateAutho(authority);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonBean(0,"修改失败");
        }

        return new JsonBean(1,"修改成功");
    }

    @RequestMapping("/authorityroot.do")
    @ResponseBody
    public List<VoMenu> authorityRoot(){

        List<VoMenu> list = userService.findAllParentAutho();

        return list;
    }

    @RequestMapping("/authorityadd.do")
    @ResponseBody
    public JsonBean authorityAdd(Authority authority,String pid){

        if(pid.equals("0")){
            authority.setParentId(0);
        }

        try {
            userService.authorityAdd(authority);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonBean(1,"操作失败");
        }

        return new JsonBean(1,"操作成功");
    }

    @RequestMapping("/coursedelete.do")
    @ResponseBody
    public JsonBean courseDelete(String id){

        boolean flag = userService.findAuthorityById(id);
        if (flag){
            return new JsonBean(1,"操作成功");
        }
        return new JsonBean(0,"操作失败");
    }

    @RequestMapping("/toIndex")
    public String toIndex(){

        return "index";
    }
    @RequestMapping("/logOut")
    public JsonBean logout(HttpServletRequest request){

        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("id");
        return new JsonBean(1,null);
    }
}

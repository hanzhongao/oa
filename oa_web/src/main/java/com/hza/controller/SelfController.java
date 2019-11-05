package com.hza.controller;

import com.hza.biz.SelfBiz;
import com.hza.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Create by hza
 * 2019-11-05 10:20
 */
@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfBiz selfBiz ;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login" ;
    }

    /**
     * 登录
     * @param session
     * @param sn
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, String sn, String password) {

        // 调用业务层登录方法
        Employee employee = this.selfBiz.login(sn, password) ;

        if (employee != null) {                            // 登录成功
            session.setAttribute("employee", employee); // 将用户信息写入session
            return "redirect:self" ;                       // 重定向到个人信息页面
        } else {                                           // 登录失败
            return "redirect:to_login" ;                   // 跳转到登录页面
        }
    }

    /**
     * 用户登出
     * @return
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("employee"); // 清空 session
        return "redirect:to_login" ; // 跳转到登录页面
    }

    /**
     * 跳转到个人信息
     * @return
     */
    @RequestMapping("/self")
    public String toSelf() {
        return "self" ;
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password" ;
    }

    /**
     * 修改密码
     * @param session  获取session
     * @param old  旧密码
     * @param new1 新密码
     * @param new2 重复对照
     * @return
     */
    @RequestMapping("change_password")
    public String changePassword(HttpSession session, String old, String new1, String new2) {

        // 从 session 中获取用户实例
        Employee employee = (Employee) session.getAttribute("employee") ;

        if (employee.getPassword().equals(old)) {  // 密码输入正确
            if (new1.equals(new2)) { // 重复输入新密码正确

                // 修改密码
                employee.setPassword(new1);
                this.selfBiz.changePassword(employee);

                return "redirect:quit" ; // 修改完毕登出
            }
        }

        // 修改失败，跳转到 修改密码页面
        return "redirect:to_change_password" ;
    }
}

package com.hza.biz;

import com.hza.entity.Employee;

/**
 * Create by hza
 * 2019-11-05 10:07
 * 登录以及个人中心
 */
public interface SelfBiz {

    /**
     * 登录
     * @param sn   员工编号
     * @param password  密码
     * @return 返回员工实例对象
     */
    Employee login(String sn, String password) ;

    /**
     * 修改密码
     * @param employee
     */
    void changePassword(Employee employee) ;

}

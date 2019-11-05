package com.hza.biz.impl;

import com.hza.biz.EmployeeBiz;
import com.hza.biz.SelfBiz;
import com.hza.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by hza
 * 2019-11-05 10:10
 */
@Service("selfBiz")
public class SelfBizImpl implements SelfBiz {

    @Autowired
    private EmployeeBiz employeeBiz ;

    @Override
    public Employee login(String sn, String password) {

        Employee user = this.employeeBiz.get(sn) ; // 根据员工编号查询员工信息

        if (user != null && user.getPassword().equals(password)) { // 如果员工编号存在，而且密码正确
            return user ; // 返回员工实例
        }
        return null; // 员工不存在或密码错误，返回null
    }

    @Override
    public void changePassword(Employee employee) {
        this.employeeBiz.edit(employee);
    }
}

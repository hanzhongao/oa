package com.hza.biz.impl;

import com.hza.biz.EmployeeBiz;
import com.hza.dao.EmployeeDao;
import com.hza.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hza
 * 2019-11-04 19:17
 */
@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {

    @Autowired
    private EmployeeDao employeeDao ;

    @Override
    public void add(Employee employee) {
        employee.setPassword("000000");
        this.employeeDao.insert(employee);
    }

    @Override
    public void edit(Employee employee) {
        this.employeeDao.update(employee);
    }

    @Override
    public void remove(String sn) {
        this.employeeDao.delete(sn);
    }

    @Override
    public Employee get(String sn) {
        return this.employeeDao.select(sn);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeDao.selectAll();
    }
}

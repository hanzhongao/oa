package com.hza.biz;

import com.hza.entity.Employee;

import java.util.List;

/**
 * Create by hza
 * 2019-11-04 19:14
 */
public interface EmployeeBiz {
    /**
     * 添加员工
     * @param employee
     */
    void add(Employee employee) ;

    /**
     * 编辑雇员
     * @param employee
     */
    void edit(Employee employee) ;

    /**
     * 删除雇员
     * @param sn
     */
    void remove(String sn) ;

    /**
     * 根据雇员编号查询雇员信息
     * @param sn
     * @return
     */
    Employee get(String sn);

    /**
     * 查询全部雇员信息
     * @return
     */
    List<Employee> getAll() ;

    /**
     * 根据部门查找员工
     * @return
     */
    List<Employee> getByPositon(String dname);
}

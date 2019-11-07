package com.hza.controller;

import com.hza.biz.DepartmentBiz;
import com.hza.biz.EmployeeBiz;
import com.hza.entity.Employee;
import com.hza.global.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by hza
 * 2019-11-04 19:21
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeBiz employeeBiz ;

    @Autowired
    private DepartmentBiz departmentBiz ;

    /**
     * 雇员列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpSession session, Map<String, Object> map) {

        Employee employee = (Employee) session.getAttribute("employee");

        // 如果登录用户是总经理，查询所有员工
        if (employee.getPost().equals(Content.POSITION_GM)) {
            map.put("emps", this.employeeBiz.getAll()) ;
        }

        // 如果登录用户是部门经理，查询部门员工
        if (employee.getPost().equals(Content.POSITION_FM)) {
            map.put("emps", this.employeeBiz.findByDepartment(employee.getDepartment().getName())) ;
        }
        return "employee_list" ;
    }

    /**
     * 添加员工前准备
     * @param map
     * @return
     */
    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("emp", new Employee()) ;
        map.put("depts", this.departmentBiz.getAll()) ;
        map.put("positions", Content.getPositions()) ;
        return "employee_add" ;
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping("/add")
    public String add(Employee employee) {
        this.employeeBiz.add(employee);
        return "redirect:list" ;
    }

    /**
     * 编辑员工前准备
     * @param map
     * @return
     */
    @RequestMapping(value = "/to_update" , params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("emp", this.employeeBiz.get(sn)) ;
        map.put("depts", this.departmentBiz.getAll()) ;
        map.put("positions", Content.getPositions()) ;
        return "employee_update" ;
    }

    /**
     * 编辑员工
     * @param employee
     * @return
     */
    @RequestMapping("/update")
    public String update(Employee employee) {
        this.employeeBiz.edit(employee);
        return "redirect:list" ;
    }

    /**
     * 删除指定编号员工
     * @param sn
     * @return
     */
    @RequestMapping("/remove")
    public String remove(String sn) {
        this.employeeBiz.remove(sn);
        return "redirect:list" ;
    }

}

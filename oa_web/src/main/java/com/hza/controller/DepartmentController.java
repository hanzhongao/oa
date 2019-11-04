package com.hza.controller;

import com.hza.biz.DepartmentBiz;
import com.hza.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Create by hza
 * 2019-11-04 15:51
 */
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz ;

    /**
     * 查看部门列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(Map<String,Object> map) {
        map.put("depts", this.departmentBiz.getAll()) ;
        return "department_list" ;
    }

    /**
     * 跳转到部门添加页面
     * @param map
     * @return
     */
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map) {
        map.put("dept", new Department()) ;
        return "department_add" ;
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */
    @RequestMapping("/add")
    public String add(Department dept) {
        this.departmentBiz.add(dept);
        return "redirect:list" ;
    }

    /**
     * 跳转到部门编辑页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String,Object> map) {
        map.put("dept", this.departmentBiz.get(sn)) ;
        return "department_update" ;
    }

    /**
     * 编辑部门
     * @param dept
     * @return
     */
    @RequestMapping("/update")
    public String update(Department dept) {
        this.departmentBiz.edit(dept);
        return "redirect:list" ;
    }

    /**
     * 删除指定部门
     * @param sn
     * @return
     */
    @RequestMapping("/remove")
    public String remove(@RequestParam(value = "sn") String sn) {
        this.departmentBiz.remove(sn);
        return "redirect:list" ;
    }

}

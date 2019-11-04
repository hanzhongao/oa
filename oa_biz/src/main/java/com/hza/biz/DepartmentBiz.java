package com.hza.biz;

import com.hza.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门业务处理接口
 */

public interface DepartmentBiz {

    /**
     * 新增部门
     * @param department
     */
    public void add(Department department) ;

    /**
     * 编辑部门信息
     * @param department
     */
    public void edit(Department department) ;

    /**
     * 删除指定部门
     * @param sn 部门编号
     */
    public void remove(String sn) ;

    /**
     * 根据编号查询部门
     * @param sn 部门编号
     * @return 部门实例
     */
    public Department get(String sn) ;

    /**
     * 查询全部部门信息
     * @return 部门列表
     */
    public List<Department> getAll() ;
}

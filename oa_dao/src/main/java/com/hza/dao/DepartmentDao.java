package com.hza.dao;

import com.hza.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-04 15:32
 */
@Repository
public interface DepartmentDao {

    /**
     * 向 部门表 （department） 添加一条数据
     * @param department
     */
    void insert(Department department) ;

    /**
     * 修改部门表（department）中数据
     * @param department
     */
    void update(Department department) ;

    /**
     * 删除部门表中指定数据
     * @param sn 部门编号
     */
    void delete(String sn) ;

    /**
     * 根据部门编号查询
     * @param sn
     * @return 返回一条部门数据
     */
    Department select(String sn) ;

    /**
     * 查询部门表中全部数据
     * @return 部门list集合
     */
    List<Department> selectAll() ;
}

package com.hza.dao;

import com.hza.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-04 18:31
 */
@Repository
public interface EmployeeDao {

    void insert(Employee employee) ;
    void update(Employee employee) ;
    void delete(String sn) ;
    Employee select(String sn) ;
    List<Employee> selectAll() ;
    List<Employee> selectByDepartment(String dname) ;
    List<Employee> selectByDeptAndPosition(@Param("dsn") String dsn,@Param("post") String post) ;
}

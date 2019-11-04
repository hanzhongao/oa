package com.hza.biz.impl;

import com.hza.biz.DepartmentBiz;
import com.hza.dao.DepartmentDao;
import com.hza.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hza
 * 2019-11-04 15:48
 */
@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {

    @Autowired
    private DepartmentDao departmentDao ; // 注入数据层对象

    @Override
    public void add(Department department) {
        this.departmentDao.insert(department);
    }

    @Override
    public void edit(Department department) {
        this.departmentDao.update(department);
    }

    @Override
    public void remove(String sn) {
        this.departmentDao.delete(sn);
    }

    @Override
    public Department get(String sn) {
        return this.departmentDao.select(sn);
    }

    @Override
    public List<Department> getAll() {
        return this.departmentDao.selectAll();
    }
}

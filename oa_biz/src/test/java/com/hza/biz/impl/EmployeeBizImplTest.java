package com.hza.biz.impl;

import com.hza.biz.EmployeeBiz;
import com.hza.dao.ClaimVoucherDao;
import com.hza.dao.EmployeeDao;
import com.hza.entity.ClaimVoucher;
import com.hza.global.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.Contended;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-biz.xml")
public class EmployeeBizImplTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ClaimVoucherDao claimVoucherDao;



    @Test
    public void test() {
        ClaimVoucher claimVoucher = this.claimVoucherDao.select(7) ;
        System.out.println("报销单创建者编号：" + claimVoucher.getCreateSn());
        System.out.println(this.employeeDao.selectByDeptAndPosition(
                this.employeeDao.select(claimVoucher.getCreateSn()).getDepartmentSn(), // 创建者的部门
                Content.POSITION_FM).get(0).getSn());
    }


}
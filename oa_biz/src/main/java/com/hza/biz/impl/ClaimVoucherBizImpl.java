package com.hza.biz.impl;

import com.hza.biz.ClaimVoucherBiz;
import com.hza.dao.ClaimVoucherDao;
import com.hza.dao.ClaimVoucherItemDao;
import com.hza.dao.DealRecordDao;
import com.hza.dao.EmployeeDao;
import com.hza.entity.ClaimVoucher;
import com.hza.entity.ClaimVoucherItem;
import com.hza.entity.DealRecord;
import com.hza.global.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by hza
 * 2019-11-05 15:21
 */
@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

    @Autowired
    private ClaimVoucherDao claimVoucherDao;

    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;

    @Autowired
    private DealRecordDao dealRecordDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void add(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems) {

        claimVoucher.setCreateTime(new Date()); // 设置报销单创建时间
        claimVoucher.setStatus(Content.STATE_CREATED); // 报销单状态为 : 新创建

        // 保存报销单
        this.claimVoucherDao.insert(claimVoucher);

        // 保存所有报销明细
        for (ClaimVoucherItem item : claimVoucherItems) {

            item.setClaimVoucherId(claimVoucher.getId()); // 设置报销单编号

            this.claimVoucherItemDao.insert(item);
        }

        // 添加处理流程
        DealRecord dealRecord = new DealRecord();
        dealRecord.setClaimVoucherId(claimVoucher.getId()); // 设置报销单编号
        dealRecord.setComment("无"); // 备注
        dealRecord.setDealResult(Content.STATE_CREATED); // 处理状态为新创建
        dealRecord.setDealSn(claimVoucher.getCreateSn()); // 待处理人为创建者
        dealRecord.setDealTime(new Date()); // 处理时间为系统当前时间
        dealRecord.setDealWay(Content.DEAL_CREATE); // 处理行为：创建

        this.dealRecordDao.insert(dealRecord); // 向处理记录表插入数据

    }

    @Override
    public Map<String, Object> get(Integer id) {
        Map<String, Object> res = new HashMap<>();
        res.put("claimVoucher", this.claimVoucherDao.select(id)); // 查询报销单信息
        res.put("claimVoucherItems", this.claimVoucherItemDao.selectByClaimVoucherId(id)); // 查询报销单详情信息
        res.put("dealRecordes", this.dealRecordDao.selectByClaimVoucherId(id)); // 查询处理记录
        return res;
    }

    @Override
    public Map<String, Object> getByCreater(String sn) {
        Map<String, Object> res = new HashMap<>();
        List<ClaimVoucher> list = this.claimVoucherDao.selectByCreater(sn);
        res.put("list", list);
        return res;
    }

    @Override
    public List<ClaimVoucher> getByDealer(String sn) {
        return this.claimVoucherDao.selectByDealer(sn);
    }

    @Override
    public void submit(Integer id) {
        ClaimVoucher claimVoucher = this.claimVoucherDao.select(id);
        claimVoucher.setStatus(Content.STATE_SUBMITED); // 状态改为已提交
        DealRecord dealRecord = this.dealRecordDao.selectByClaimVoucherId(id).get(0);

        claimVoucher.setNextDealSn(// 下个处理人改为 部门经理
                this.employeeDao.selectByDeptAndPosition(
                        this.employeeDao.select(claimVoucher.getCreateSn()).getDepartmentSn(), // 创建者的部门
                        Content.POSITION_FM).get(0).getSn());

        // 添加处理记录

        dealRecord.setDealWay(Content.DEAL_SUBMIT); // 操作：已提交
        dealRecord.setDealTime(new Date());         // 操作时间为系统时间
        dealRecord.setDealSn(claimVoucher.getCreateSn()); // 操作人为创建人
        dealRecord.setDealResult(Content.STATE_SUBMITED); // 处理状态： 已提交

        this.claimVoucherDao.update(claimVoucher);
        this.dealRecordDao.insert(dealRecord);
    }

    @Override
    public void check(DealRecord dealRecord) {

        ClaimVoucher claimVoucher = this.claimVoucherDao.select(dealRecord.getClaimVoucherId());

        dealRecord.setDealTime(new Date());


        if (dealRecord.getDealWay().equals(Content.DEAL_PASS)) {  // 通过

            // 1、审核人为部门经理
            if (dealRecord.getDealer().getPost().equals(Content.POSITION_FM)) {
                // 总金额不超过5000
                if (claimVoucher.getTotalAmount() < 5000) {
                    // 状态设置为通过
                    claimVoucher.setStatus(Content.STATE_CHECKED);
                    // 下一个处理交给财务
                    claimVoucher.setNextDealSn(this.employeeDao.selectByDeptAndPosition(null, Content.POSITION_CASHIER).get(0).getSn());

                    // 添加处理记录
                    dealRecord.setDealResult(Content.STATE_CHECKED); // 处理结果：已审核
                    dealRecord.setDealWay(Content.DEAL_PASS); // 处理方式：通过

                    this.claimVoucherDao.update(claimVoucher);
                    this.dealRecordDao.insert(dealRecord);

                } else { // 总金额超过5000
                    // 状态设置为待复审
                    claimVoucher.setStatus(Content.STATE_RECHECK);
                    // 下一个处理人为总经理
                    claimVoucher.setNextDealSn(this.employeeDao.selectByDeptAndPosition(null, Content.POSITION_GM).get(0).getSn());

                    // 添加处理记录
                    dealRecord.setDealResult(Content.STATE_RECHECK); // 处理结果：待复审
                    dealRecord.setDealWay(Content.DEAL_PASS); // 处理方式：通过

                    this.claimVoucherDao.update(claimVoucher);
                    this.dealRecordDao.insert(dealRecord);
                }

            }

            // 2、审核人为总经理
            if (dealRecord.getDealer().getPost().equals(Content.POSITION_GM)) {
                // 状态设置为通过
                claimVoucher.setStatus(Content.STATE_CHECKED);
                // 下一个处理交给财务
                claimVoucher.setNextDealSn(this.employeeDao.selectByDeptAndPosition(null, Content.POSITION_CASHIER).get(0).getSn());

                // 添加处理记录
                dealRecord.setDealResult(Content.STATE_CHECKED); // 处理结果：已审核
                dealRecord.setDealWay(Content.DEAL_PASS); // 处理方式：通过

                this.claimVoucherDao.update(claimVoucher);
                this.dealRecordDao.insert(dealRecord);
            }



        } else if (dealRecord.getDealWay().equals(Content.DEAL_BACK)) {  // 打回

        } else if (dealRecord.getDealWay().equals(Content.DEAL_REJECT)) { // 拒绝

        } else if (dealRecord.getDealWay().equals(Content.DEAL_PAID)) { // 打款

        }
    }

}



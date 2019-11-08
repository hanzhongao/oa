package com.hza.biz;


import com.hza.entity.ClaimVoucher;
import com.hza.entity.ClaimVoucherItem;
import com.hza.entity.DealRecord;

import java.util.List;
import java.util.Map;

/**
 * Create by hza
 * 2019-11-05 15:18
 */
public interface ClaimVoucherBiz {

    /**
     * 新增报销单
     * @param claimVoucher 报销单实例
     * @param claimVoucherItems 报销单明细列表
     */
    void add(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems) ;

    /**
     * 根据报销单id查询
     * @param id
     * @return
     */
    Map<String,Object> get(Integer id) ;

    /**
     * 根据创建人查询报销单
     * @param sn
     * @return
     */
    Map<String,Object> getByCreater(String sn) ;

    /**
     * 根据待处理人查询 报销单
     * @param sn
     * @return
     */
    List<ClaimVoucher> getByDealer(String sn) ;

    /**
     * 提交报销单
     * @param id
     */
    void submit(Integer id) ;

    /**
     * 审核报销单
     * @param dealRecord
     */
    void check(DealRecord dealRecord);

    /**
     * 打款
     * @param dealRecord
     */
    void pay(DealRecord dealRecord) ;

    /**
     * 修改
     * @param claimVoucher
     * @param claimVoucherItems
     */
    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems) ;
}

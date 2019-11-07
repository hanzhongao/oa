package com.hza.dao;

import com.hza.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-05 13:30
 */
@Repository
public interface ClaimVoucherDao {

    /**
     * 向报销单表中插入一条数据
     * @param claimVoucher
     */
    void insert(ClaimVoucher claimVoucher) ;

    /**
     * 修改保险单表中指定数据
     * @param claimVoucher
     */
    void update(ClaimVoucher claimVoucher) ;

    /**
     * 删除保险单表中指定数据
     * @param id 报销单id
     */
    void delete(Integer id) ;

    /**
     * 根据报销单编号查询报销单
     * @param id 编号
     * @return
     */
    ClaimVoucher select(Integer id) ;

    /**
     * 按照创建者查询全部报销单
     * @param sn 创建者编号
     * @return
     */
    List<ClaimVoucher> selectByCreater(String sn) ;

    /**
     * 按照待处理人查询全部报销单
     * @param sn 待处理人编号
     * @return
     */
    List<ClaimVoucher> selectByDealer(String sn) ;



}

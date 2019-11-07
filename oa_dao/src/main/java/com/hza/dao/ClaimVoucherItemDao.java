package com.hza.dao;

import com.hza.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-05 14:06
 */
@Repository
public interface ClaimVoucherItemDao {

    /**
     * 向报销明细表添加一条数据
     * @param claimVoucherItem
     */
    void insert(ClaimVoucherItem claimVoucherItem) ;

    /**
     * 修改报销明细表中指定数据
     * @param claimVoucherItem
     */
    void update(ClaimVoucherItem claimVoucherItem) ;

    /**
     * 删除报销明细表中指定数据
     * @param id
     */
    void delete(Integer id) ;

    /**
     * 从报销明细表中查询指定报销单的全部明细
     * @param id 报销单编号
     * @return
     */
    List<ClaimVoucherItem> selectByClaimVoucherId(Integer id) ;
}

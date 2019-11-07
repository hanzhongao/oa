package com.hza.dao;

import com.hza.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-05 14:28
 */
@Repository
public interface DealRecordDao {

    /**
     * 向处理记录表中添加一条数据
     * @param dealRecord
     */
    void insert(DealRecord dealRecord) ;

    /**
     * 从报销单记录表中查询指定报销单的全部处理记录
     * @param id
     * @return
     */
    List<DealRecord> selectByClaimVoucherId(Integer id) ;
}

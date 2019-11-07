package com.hza.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Create by hza
 * 2019-11-05 13:26
 * 处理记录表
 *  private Integer id                ;//    int not null auto_increment,
 *  private Integer claim_voucher_id  ;//    int,
 *  private String  deal_sn            ;//   char(5),
 *  private Date    deal_time          ;//   datetime,
 *  private String  deal_way           ;//   varchar(20),
 *  private String  deal_result        ;//   varchar(20),
 *  private String  comment            ;//   varchar(100),
 */
public class DealRecord {

    private Integer  id                ; // 处理记录编号
    private Integer  claimVoucherId    ; // 报销单编号
    private String  dealSn             ; // 处理人编号

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date    dealTime           ; // 处理时间
    private String  dealWay            ; // 处理方式
    private String  dealResult         ; // 处理结果
    private String  comment            ; // 说明

    private Employee dealer            ; // 处理人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClaimVoucherId() {
        return claimVoucherId;
    }

    public void setClaimVoucherId(Integer claimVoucherId) {
        this.claimVoucherId = claimVoucherId;
    }

    public String getDealSn() {
        return dealSn;
    }

    public void setDealSn(String dealSn) {
        this.dealSn = dealSn;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }
}

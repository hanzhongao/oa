package com.hza.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Create by hza
 * 2019-11-05 13:15
 *  报销单表
 *   private Integer id            ;      int not null auto_increment,
 *   private String  cause          ;     varchar(100),
 *   private String  create_sn      ;     char(5),
 *   private Date    create_time    ;     datetime,
 *   private String  next_deal_sn   ;     char(5),
 *   private Double  total_amount   ;     double,
 *   private String  status         ;     varchar(20),
 */
public class ClaimVoucher {

    private Integer id             ;  // 报销单编号
    private String  cause          ;  // 事由
    private String  createSn       ;  // 创建人编号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    createTime     ;  // 创建时间
    private String  nextDealSn     ;  // 下一个处理人编号
    private Double  totalAmount    ;  // 总金额
    private String  status         ;  // 报销单状态

    private Employee creater ;  // 创建人
    private Employee dealer  ;  // 下一个处理人

    public ClaimVoucher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCreateSn() {
        return createSn;
    }

    public void setCreateSn(String createSn) {
        this.createSn = createSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNextDealSn() {
        return nextDealSn;
    }

    public void setNextDealSn(String nextDealSn) {
        this.nextDealSn = nextDealSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getCreater() {
        return creater;
    }

    public void setCreater(Employee creater) {
        this.creater = creater;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "ClaimVoucher{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", createSn='" + createSn + '\'' +
                ", createTime=" + createTime +
                ", nextDealSn='" + nextDealSn + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", creater=" + creater +
                ", dealer=" + dealer +
                '}';
    }
}

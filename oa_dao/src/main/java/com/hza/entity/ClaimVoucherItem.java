package com.hza.entity;

/**
 * Create by hza
 * 2019-11-05 13:21
 * 报销明细表
 *    id                   int not null auto_increment,
 *    claim_voucher_id     int,
 *    item                 varchar(20),
 *    amount               double,
 *    comment              varchar(100),
 */
public class ClaimVoucherItem {

    private Integer id                 ; // 报销条目编号
    private Integer claimVoucherId     ; // 报销单编号
    private String  item               ; // 费用类别
    private Double  amount             ; // 消费金额
    private String  comment            ; // 说明

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package com.hza.dto;

import com.hza.entity.ClaimVoucher;
import com.hza.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by hza
 * 2019-11-05 15:26
 */
@Repository
public class ClaimVoucherInfo {
    private ClaimVoucher claimVoucher ;
    private List<ClaimVoucherItem> items ;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}

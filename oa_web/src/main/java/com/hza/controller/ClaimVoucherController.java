package com.hza.controller;

import com.hza.biz.ClaimVoucherBiz;
import com.hza.dto.ClaimVoucherInfo;
import com.hza.entity.ClaimVoucher;
import com.hza.entity.DealRecord;
import com.hza.entity.Employee;
import com.hza.global.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by hza
 * 2019-11-05 15:38
 */
@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Autowired
    private ClaimVoucherBiz claimVoucherBiz ;

    /**
     * 添加报销单前准备
     * @param map
     * @return
     */
    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map) {
        map.put("costTypes", Content.getCostTypes()) ;
        map.put("info", new ClaimVoucherInfo()) ;
        return "claim_voucher_add" ;
    }

    /**
     * 添加报销单
     * @param session
     * @param info
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpSession session, ClaimVoucherInfo info) {
        Employee employee = (Employee) session.getAttribute("employee") ;

        info.getClaimVoucher().setCreateSn(employee.getSn()); // 设置创建者编号
        info.getClaimVoucher().setNextDealSn(employee.getSn()); // 设置待处理者编号，下一个待处理者为创建者本人

        this.claimVoucherBiz.add(info.getClaimVoucher(), info.getItems()); // 保存报销单

        return "redirect:self" ;
    }

    /**
     * 查看个人报销单
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/self")
    public String self(HttpSession session, Map<String,Object> map) {
        Employee employee = (Employee) session.getAttribute("employee") ;
        map.put("lists", this.claimVoucherBiz.getByCreater(employee.getSn()).get("list")) ;
//        map = this.claimVoucherBiz.getByCreater(employee.getSn());
        return "claim_voucher_self" ;
    }

    /**
     * 报销单详细信息
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Integer id, Map<String, Object> map) {

        Map<String, Object> res = this.claimVoucherBiz.get(id) ;

        map.put("claimVoucher",res.get("claimVoucher")) ;
        map.put("claimVoucherItems",res.get("claimVoucherItems")) ;
        map.put("dealRecordes",res.get("dealRecordes")) ;
        // claimVoucher     -> 查询报销单信息
        // claimVoucherItems -> 查询报销单详情信息
        // dealRecordes       -> 查询处理记录

        return "claim_voucher_detail" ;
    }

    /**
     * 根据 待处理人 查询报销单
     * @param session
     * @return
     */
    @RequestMapping("/deal")
    public String deal(HttpSession session, Map<String,Object> map) {

        Employee employee = (Employee) session.getAttribute("employee") ;

        map.put("claimVouchers", this.claimVoucherBiz.getByDealer(employee.getSn())) ; // 查询所有当前登录用户的待处理报销单

        return "claim_voucher_deal" ;
    }

    /**
     * 提交报销单
     * @param id
     * @return
     */
    @RequestMapping("/submit")
    public String submit(Integer id) {
        this.claimVoucherBiz.submit(id);
        return "redirect:deal" ;
    }

    /**
     * 跳转到审核页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/to_check")
    public String toCheck(Integer id, Map<String, Object> map) {
        Map<String, Object> res = this.claimVoucherBiz.get(id) ;

        map.put("claimVoucher",res.get("claimVoucher")) ;
        map.put("claimVoucherItems",res.get("claimVoucherItems")) ;
        map.put("dealRecordes",res.get("dealRecordes")) ;

        DealRecord dealRecord = new DealRecord();
        dealRecord.setClaimVoucherId(id);
        map.put("dealRecord", dealRecord) ;
        // claimVoucher     -> 查询报销单信息
        // claimVoucherItems -> 查询报销单详情信息
        // dealRecordes       -> 查询处理记录

        return "claim_voucher_check" ;
    }

    /**
     * 审核操作
     * @param dealRecord 处理记录
     * @return
     */
    @RequestMapping("/check")
    public String check(HttpSession session, DealRecord dealRecord) {

        // 获取当前登录用户
        Employee employee = (Employee) session.getAttribute("employee") ;

        // 设置处理人
        dealRecord.setDealSn(employee.getSn());
        dealRecord.setDealer(employee);

        // 调用审核业务
        this.claimVoucherBiz.check(dealRecord) ;

        // 返回待处理页面
        return "redirect:deal" ;
    }

}

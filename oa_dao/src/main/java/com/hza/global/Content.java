package com.hza.global;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by hza
 * 2019-11-04 14:19
 * 数据字典类
 */
public class Content {
    // 职位
    public static final String POSITION_STAFF = "员工" ;
    public static final String POSITION_FM    = "部门经理" ;
    public static final String POSITION_GM    = "总经理" ;
    public static final String POSITION_CASHIER = "财务" ;

    public static List<String> getPositions() {
        List<String> positions = new ArrayList<>() ;
        positions.add(POSITION_STAFF) ;
        positions.add(POSITION_FM) ;
        positions.add(POSITION_GM) ;
        positions.add(POSITION_CASHIER) ;

        return positions ;
    }

    // 费用类型
    public static final String COST_TRAFFFIC = "交通" ;
    public static final String COST_MEAL     = "餐饮" ;
    public static final String COST_HOTEL    = "住宿" ;
    public static final String COST_OFFICE   = "办公" ;

    public static List<String> getCostTypes() {
        List<String> costTypes = new ArrayList<>() ;
        costTypes.add(COST_TRAFFFIC) ;
        costTypes.add(COST_MEAL) ;
        costTypes.add(COST_HOTEL) ;
        costTypes.add(COST_OFFICE) ;

        return costTypes ;
    }

    // 审核额度
    public static final Double CHECK_LIMIT = 5000.00 ;

    // 报销单状态

    public static final String STATE_CREATED    = "新创建";
    public static final String STATE_SUBMITED   = "已提交";
    public static final String STATE_CHECKED    = "已审核";
    public static final String STATE_BACK       = "已打回";
    public static final String STATE_TERMINATED = "已终止";
    public static final String STATE_RECHECK    = "待复审";
    public static final String STATE_PAID       = "已打款";

    public static List<String> getStates() {
        List<String> states = new ArrayList<>() ;
        states.add(STATE_CREATED) ;
        states.add(STATE_SUBMITED) ;
        states.add(STATE_CHECKED) ;
        states.add(STATE_BACK) ;
        states.add(STATE_TERMINATED) ;
        states.add(STATE_RECHECK) ;
        states.add(STATE_PAID) ;

        return states ;
    }

    // 处理方式

    public static final String DEAL_CREATE = "创建";
    public static final String DEAL_SUBMIT = "提交";
    public static final String DEAL_UPDATE = "修改";
    public static final String DEAL_BACK   = "打回";
    public static final String DEAL_REJECT = "拒绝";
    public static final String DEAL_PASS   = "通过";
    public static final String DEAL_PAID   = "打款";

    public static List<String> getDeals() {
        List<String> deals = new ArrayList<>() ;
        deals.add(DEAL_CREATE) ;
        deals.add(DEAL_SUBMIT) ;
        deals.add(DEAL_UPDATE) ;
        deals.add(DEAL_BACK  ) ;
        deals.add(DEAL_REJECT) ;
        deals.add(DEAL_PASS  ) ;
        deals.add(DEAL_PAID  ) ;

        return deals ;
    }

}

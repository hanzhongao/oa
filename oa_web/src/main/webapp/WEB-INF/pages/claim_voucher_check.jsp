<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 报销单详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">事由</div>
                        <div class="col-md-6">${claimVoucher.cause}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建人</div>
                        <div class="col-md-4">${claimVoucher.creater.name}</div>
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4"><spring:eval expression="claimVoucher.createTime"/></div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">待处理人</div>
                        <div class="col-md-4">${claimVoucher.dealer.name}</div>
                        <div class="col-md-2">状态</div>
                        <div class="col-md-4">${claimVoucher.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 费用明细 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${claimVoucherItems}" var="item">
                            <div class="col-md-3">${item.item}</div>
                            <div class="col-md-3">${item.amount}</div>
                            <div class="col-md-5">${item.comment}</div>
                        </c:forEach>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">总金额</div>
                        <div class="col-md-6">${claimVoucher.totalAmount}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${dealRecordes}" var="dealRecord">
                            <div class="col-md-2">操作人:&nbsp;&nbsp;${dealRecord.dealer.name}</div>
                            <div class="col-md-2"><spring:eval expression="dealRecord.dealTime"/></div>
                            <div class="col-md-2">操作:&nbsp;&nbsp;${dealRecord.dealWay}</div>
                            <div class="col-md-2">状态:&nbsp;&nbsp;${dealRecord.dealResult}</div>
                            <div class="col-md-3">备注:&nbsp;&nbsp;${dealRecord.comment}</div>
                        </c:forEach>
                    </div>
                    <form:form id="admin-form" name="addForm" action="/claim_voucher/check" modelAttribute="dealRecord">
                        <form:hidden path="claimVoucherId" />
                        <form:hidden path="dealWay" />
                        <div class="panel-body bg-light">
                            <div class="section">
                                <label for="comment" class="field prepend-icon">
                                    <form:input path="comment" class="gui-input" placeholder="备注..."/>
                                    <label for="comment" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="panel-footer text-right">

                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='通过'; addForm.submit();">通过</button>
                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='打回'; addForm.submit();">打回</button>
                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='拒绝'; addForm.submit();">拒绝</button>

                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="foot.jsp"/>
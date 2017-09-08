<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>佣金管理</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=045" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  APP ={
        	   cplUrl :  "weixin/wechat!complain",                //申诉url
        	   list1Url: "weixin/wechat!money1List",
        	   list2Url: "weixin/wechat!money2List",
        	   accountUpdate: "weixin/wechat!updateAccountInfo",
        	   usableApply : "weixin/wechat!usableApply",
        	   cashApply : "weixin/wechat!cashApply",
        	   tabId : "<s:property value='#request.tabId' />" || "",
        	   cash: "<s:property value='#request.agentUser.account.cash' />"
        }
    </script>
		


	</head>
	<body class="bg">
		<div style="padding-top: 16px;" id="mydiv">
			<dl class="m_2 m_2_show" data-index="1" id="dl1">
				<dd>
					可结佣金
				</dd>
				<dt class="m_txt1">
					<s:property value="#request.agentUser.account.usable" />
					<span class="yuan">元</span>
				</dt>
				<dt class="m_txt2">
					申请结佣
				</dt>
				<dt class="m_2_b"></dt>
			</dl>
			<dl class="m_3" data-index="2" id="dl2">
				<dd>
					可提现金
				</dd>
				<dt class="m_txt1">
					<s:property value="#request.agentUser.account.cash" />
					<span class="yuan">元</span>
				</dt>
				<dt class="m_txt2">
					申请提现
				</dt>
			</dl>
			<div class="clear"></div>
		</div>
		
		<!-- 佣金信息 -->
		<div style="padding: 16px;" id="list1" >
			<ul class="yj_lists">
				<li>
					<div class="xm_tpc2">
						<span>可结佣金清单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total" />元</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista" style="display: none;">
						<li id="li_data">
							<div class="yj_contain">
								<div class="yj_tpc">
									客户签约佣金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_1" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust tab_cust_b">
									<tr>
										<th align="left" valign="middle">
											姓名
										</th>
<%--										<th align="left" valign="middle">--%>
<%--											电话--%>
<%--										</th>--%>
										<th align="center" valign="middle">
											签约楼盘
										</th>
<%--										<th align="left" valign="middle">--%>
<%--											签约套数--%>
<%--										</th>--%>
										<th align="right" valign="middle">
											佣金总额
										</th>
									</tr>
									<s:iterator value="#request.list1" var="item" status="st">
										<tr>
											<td align="left" valign="middle">
												<s:property value="#item.app.customerName" />
											</td>
<%--											<td align="left" valign="middle">--%>
<%--												<s:property value="#item.app.customerDecimal" />--%>
<%--											</td>--%>
											<td align="center" valign="middle">
												<s:property value="#item.app.houseInfo.projectName" />
											</td>
<%--											<td align="left" valign="middle">--%>
<%--												<s:property value="#item.app.houseCount" />--%>
<%--											</td>--%>
											<td align="right" valign="middle">
												<s:property
													value="#item.app.houseCount*#item.app.housePrice" />
												元
											</td>
										</tr>
									</s:iterator>
								</table>
								<div class="yj_tpc">
									客户到访奖励&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_2" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust tab_cust_b">
									<tr>
										<th align="left" valign="middle">
											姓名
										</th>
<%--										<th align="left" valign="middle">--%>
<%--											电话--%>
<%--										</th>--%>
										<th align="center" valign="middle">
											到访楼盘
										</th>
<%--										<th align="left" valign="middle">--%>
<%--											到访时间--%>
<%--										</th>--%>
										<th align="right" valign="middle">
											奖励金额
										</th>
									</tr>
									<s:iterator value="#request.list2" var="item" status="st">
										<tr>
											<td align="left" valign="middle">
												<s:property value="#item.app.customerName" />
											</td>
<%--											<td align="left" valign="middle">--%>
<%--												<s:property value="#item.app.customerDecimal" />--%>
<%--											</td>--%>
											<td align="center" valign="middle">
												<s:property value="#item.app.houseInfo.projectName" />
											</td>
<%--											<td align="left" valign="middle">--%>
<%--												<s:date name="%{#item.createTime}" format="yyyy-MM-dd" />--%>
<%--											</td>--%>
											<td align="right" valign="middle">
												<s:property value="#item.amount" />
												元
											</td>
										</tr>
									</s:iterator>
								</table>
								
								
								
								<div class="yj_tpc">
									首次带看奖励&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_3" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="tab_cust" style="border-bottom: 2px solid #e0e0e0;">
								<tr>
									<th align="left" valign="middle">
										姓名
									</th>
<%--									<th align="center" valign="middle">--%>
<%--										电话--%>
<%--									</th>--%>
									<th align="center" valign="middle">
										带看楼盘
									</th>
<%--									<th align="center" valign="middle">--%>
<%--										带看时间--%>
<%--									</th>--%>
									<th align="right" valign="middle">
										奖励金额
									</th>
								</tr>
							   <s:iterator value="#request.list3" var="item" status="st">
								<tr>
									<td align="left" valign="middle">
										<s:property value="#item.app.customerName" />
									</td>
<%--									<td align="center" valign="middle">--%>
<%--										<s:property value="#item.app.customerDecimal" />--%>
<%--									</td>--%>
									<td align="center" valign="middle">
										<s:property value="#item.app.houseInfo.projectName" />
									</td>
<%--									<td align="center" valign="middle">--%>
<%--										<s:date name="%{#item.createTime}" format="yyyy-MM-dd" />--%>
<%--									</td>--%>
									<td align="right" valign="middle">
										<s:property value="#item.amount" />元
									</td>
								</tr> 
							  </s:iterator>
							</table>

								<div class="yj_tpc">
									推荐经纪人注册奖励&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_4" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust" style="border-bottom: 2px solid #e0e0e0;">
									<tr>
										<th align="left" valign="middle">
											姓名
										</th>
										<th align="center" valign="middle">
											电话
										</th>
										<th align="center" valign="middle">
											注册时间
										</th>
										<th align="right" valign="middle">
											奖励金额
										</th>
									</tr>
								<s:iterator value="#request.list4" var="item" status="st">
								  <tr>
									<td align="left" valign="middle">
										<s:property value="#item.app.customerName" />
									</td>
									<td align="center" valign="middle">
										<s:property value="#item.app.customerDecimal" />
									</td>
									<td align="center" valign="middle">
										<s:date name="%{#item.createTime}" format="yyyy-MM-dd" />
									</td>
									<td align="right" valign="middle">
										<s:property value="#item.amount" />元
									</td>
								  </tr> 
								</s:iterator>
								</table>

								<div class="yj_tpc">
									红包派发&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_5" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust" style="border-bottom: 2px solid #e0e0e0;">
									<tr>
										<th align="left" valign="middle">
											派发时间
										</th>
										<th align="center" valign="middle">
											派发备注
										</th>
										<th align="right" valign="middle">
											派发金额
										</th>
									</tr>
								<s:iterator value="#request.list5" var="item" status="st">
								<tr>
									<td align="left" valign="middle">
										<s:date name="%{#item.createTime}" format="yyyy-MM-dd" />
									</td>
									<td align="center" valign="middle">
<%--										<s:property value="#item.app.remark" />--%>
注册送红包
									</td>
									<td align="right" valign="middle">
										<s:property value="#item.amount" />元
									</td>
								</tr> 
								</s:iterator>
									
								</table>

								<div class="yj_tpc">
									其它活动&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.total_6" />元
								</div>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust" style="border-bottom: 2px solid #e0e0e0;">
									<tr>
										<th align="left" valign="middle">
											事项
										</th>
										<th align="center" valign="middle">
											时间
										</th>
										<th align="right" valign="middle">
											金额
										</th>
									</tr>
								<s:iterator value="#request.list6" var="item" status="st">
								   <tr>
								    <td align="left" valign="middle">
										<s:property value="#item.app.remark" />元
									</td>
									<td align="center" valign="middle">
										<s:date name="%{#item.createTime}" format="yyyy-MM-dd" />
									</td>
									<td align="right" valign="middle">
										<s:property value="#item.amount" />元
									</td>
								  </tr> 
								</s:iterator>
								</table>



								<div align="center" style="line-height: 32px">
									<strong><font color="#ff671c">可结佣金总额：<s:property value="#request.total" />元</font>
									</strong>
								</div>
							</div>
							<s:if test="#request.total != 0">
							    <div class="btn_w">
								<input  type="button" value="一键确认申请" class="btn_zc1" id="sub1"
									style="margin-top: 0;" />
							</div>
							</s:if>
							
						</li>
						<li class="yj_sucess" id="li_suc" style="display: none;">
							<p>
								<img src="resources/images/su_img3.png" width="50" height="50" />
							</p>
							<p>
								申请已提交！请等待审核
							</p>

						</li>
					</ul>
				</li>
				<li>
					<div class="xm_tpc2">
						<span>结佣审核办理中&nbsp;&nbsp;&nbsp;<s:property value="#request.agentUser.account.pending" />元</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista" style="display: none;">
							<li>
								<div class="yj_contain">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										class="tab_cust tab_cust_b">
										<tr>
											<th align="left" valign="middle">
												申请时间
											</th>
											<th align="center" valign="middle">
												金额
											</th>
											<th align="center" valign="middle">
												类别
											</th>
<%--											<th align="left" valign="middle">--%>
<%--												备注--%>
<%--											</th>--%>
											<th align="right" valign="middle">
												状态
											</th>
										</tr>
									<s:iterator value="#request.historyList" var="item" status="st">
										<tr>
											<td align="left" valign="middle">
												<s:property value="#item.applicationTimeDesc" />
											</td>
											<td align="center" valign="middle">
												<s:property value="#item.amountMoney" />
											</td>
											<td align="center" valign="middle">
												<s:if test="#item.appType == 1">
										                             签约结佣
										        </s:if>
												<s:if test="#item.appType == 2">
										                           客户到访奖
										        </s:if>
												<s:if test="#item.appType == 3">
										                         首次带看奖
										         </s:if>
												<s:if test="#item.appType == 4">
										                          推荐人注册奖
										        </s:if>
												<s:if test="#item.appType == 5">
										                          注册送红包
										        </s:if>
												<s:if test="#item.appType == 6">
										                          其他活动
										        </s:if>
											</td>
<%--											<td align="left" valign="middle">--%>
<%--												<s:property value="#item.remark" />--%>
<%--											</td>--%>
											<td align="right" valign="middle">
											   <s:if test="#item.resultStatus == 0">
											       <span class="c_green">审核中</span>
											   </s:if>
											   <s:if test="#item.resultStatus == 1 || #item.resultStatus ==3">
											       <span class="c_orange">审核通过</span>
											   </s:if>
											   <s:if test="#item.resultStatus == 2">
											       <span class="c_red">审核未通过</span>
											   </s:if>
<%--												<span class=" c_blue">等待审核</span>--%>
												<%--										<p class="c_orange">--%>
												<%--											等待办理--%>
												<%--										</p>--%>
												<%--										<span class="c_red">审核失败</span>--%>
												<%--										<span class="c_green">办理中</span>--%>
												<%--										审核中--%>
											</td>
										</tr>
									</s:iterator>

								</table>

								</div>

							</li>
						</ul>
				</li>
				<li>
					<div class="xm_tpc2">
						<span>已结佣金总额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.agentUser.account.total" />元</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista" style="display: none;">
						<li>
							<div class="yj_contain">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust tab_cust_b" id="tab1">
									<tr>
										<th align="left" valign="middle">
											结佣时间
										</th>
										<th align="center" valign="middle">
											金额
										</th>
										<th align="center" valign="middle">
											类别
										</th>
										<th align="right" valign="middle">
											状态
										</th>
									</tr>
								</table>
								<div class="btn_w">
									<p class="more1">
										<a href="javascript:;" id="more1">查看更多</a>
									</p>
								</div>

							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- 佣金信息结束 -->
		
		
		<!-- 现金信息 -->
		<div style="padding: 16px;display: none;" id="list2">
			<ul class="yj_lists">
				<li>
					<div class="xm_tpc2" id="bankInfo">
						<span>请绑定您的银行卡号</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista part_st" style="display: none;">
						
						<s:if test="#request.sysUser.realName == '' || #request.sysUser.realName == null || #request.agentUser.bankName == '' || #request.agentUser.bankName == null || #request.agentUser.bankAccount =='' || #request.agentUser.bankAccount == null">
						     <li class="input_g" style="margin-bottom: 0;">
							   <img src="resources/images/icon1.png" alt="" class="input_icon_aa" />
							   <div class="input_ab"><input  type="text" class="input_aa" placeholder="姓名" style="background: 0" id="realName" value="<s:property value="#request.sysUser.realName" />"/></div>
						    </li>
						    <li class="input_g bor_tb" style="margin-bottom: 0;">
							   <img src="resources/images/icon_10.png" alt="" class="input_icon_aa" style="left: 10px;" />
							   <div class="input_ab"><input  type="text" class="input_aa" placeholder="开户银行    如：中国工商银行华侨路支行" style="width: 99% !important;" id="bankName" value="<s:property value="#request.agentUser.bankName" />"/></div>
						   </li>
						   <li class="input_g" style="margin-bottom: 0 ;border-bottom:1px solid #eee;">
							  <img src="resources/images/icon_10.png" alt="" class="input_icon_aa" style="left: 10px;" />
							  <div class="input_ab"><input  type="tel" class="input_aa" placeholder="银行卡号" style="width: 99% !important;" id="bankAccount" value="<s:property value="#request.agentUser.bankAccount" />"/></div>
						   </li>
						   <li>
								<div class="btn_w" id="_div_en">
									<input type="button" value="确认提交" class="btn_zc1" id="sub2" />
								</div>
								<div class="btn_w" id="_div_dis" style="display: none;">
									<input  type="button" value="√ 已提交" class="btn_zc1_gray" disabled="disabled"/>
								</div>
							</li>
						  
						</s:if>
						<s:else>
							<li class="input_g" style="margin-bottom: 0;">
								<img src="resources/images/icon1.png" alt="" class="input_icon" style="left: 10px;" />
								<input  type="text" class="input1_yj" value="<s:property value="#request.sysUser.realName" />" style="background: 0;" id="realName" readonly="readonly"/>
							</li>
							<li class="input_g" style="margin-bottom: 0;">
								<img src="resources/images/icon_10.png" alt="" class="input_icon" style="left: 10px;" />
								<input  type="text" class="input1_yj" value="<s:property value="#request.agentUser.bankName" />" style="width: 99% !important;" id="bankName" readonly="readonly"/>
							</li>
							<li class="input_g" style="margin-bottom: 0;">
								<img src="resources/images/icon_10.png" alt="" class="input_icon" style="left: 10px;" />
								<input  type="text" class="input1_yj" value="<s:property value="#request.agentUser.bankAccount" />" style="width: 99% !important;" id="bankAccount" readonly="readonly"/>
							</li>
							<li>
<%--								<div class="btn_w">--%>
<%--									<input  type="button" value="√ 已提交" class="btn_zc1_gray" />--%>
<%--								</div>--%>
							</li>
						</s:else>
					</ul>
				</li>
				<li>
					<div class="xm_tpc2" id="moneyInfo">
						<span>申请提现</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista part_st" style="display: none;">
							<li class="input_g" style="margin-bottom: 0;border-bottom:1px solid #eee;">
								<img src="resources/images/icon8.png" alt="" class="input_icon_aa"  />
								<div class="input_ab"><input  type="tel" class="input_aa" placeholder="请输入提现金额（元）" style="background: 0;" id="txMoney"/></div>
							</li>

							<li id="li_money">
							  <s:if test="#request.agentUser.account.cash != 0">
							     <div class="btn_w">
									<input  type="button" value="确认提交" class="btn_zc1" id="sub3"/>
								</div>
							  </s:if>
								
							</li>
						</ul>
				</li>
				<li>
					<div class="xm_tpc2" id="div_tx">
						<span>提现记录</span>
						<img src="resources/images/arrow1.png" width="16" height="16" class="arrow2" />
					</div>
					<ul class="yj_lista" style="display: none;">
						<li style="margin: 0;">
							<div class="yj_contain">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="tab_cust tab_cust_b" id="tab2"
									style="margin-bottom: 0 !important;">
									<tr>
										<th align="left" valign="middle" >
											申请提现时间
										</th>
										<th  align="center" valign="middle">
											金额
										</th>
										<th  align="right" valign="middle">
											结果
										</th>
									</tr>
								</table>
								<div class="btn_w">
									<p class="more1">
										<a href="javascript:;" id="more2">查看更多</a>
									</p>
								</div>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	   <!-- 现金信息结束 -->
	   <script>

        (function(l){
            seajs.config({
                base:"<%=basePath%>/resources/weixin",
                map:[
                    [".js", (l&&l[1]||"")+".js?v=044"]
                ]
            });
            //
            seajs.use("<%=basePath%>resources/weixin/js_cmd/brokerage.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
	</body>
</html>

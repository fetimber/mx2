<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<s:include value="../common/meta.jsp" />
		<style type="text/css">
			.tab_1 td{font-family: "Courier New","微软雅黑"}
			.input_1 {width:196px;font-family: "Courier New","微软雅黑"}
			.ui-menu-item{font-family: "Courier New","微软雅黑"}
		</style>
		<script type="text/javascript">
			function _forward_page(page) {
				$(":hidden[name='page.current']").val(page);
				$("#usersview").submit();
			}
			$(function() {
				$("select").selectmenu({width:'207px'});
				$("input:text").addClass("input_1");
				$(".timer").datepicker({ autoSize: true });

				$("#customer_form").validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 25, +5',
					maxErrorsPerField: true,
					autoHidePrompt: true,
					autoHideDelay: 3000,
					focusFirstField: false
				});
			});
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;&gt;&nbsp;客户管理&nbsp;&gt;&nbsp;客户跟踪
		</div>
		<div class="m_w">
			<!--后台用户-->
			<s:form id="customer_form" action="customer!track_confirm" namespace="/admin">
				<s:hidden name="customerApplication.id" />
				<s:hidden name="customerApplication.agentInfo.id" />
				<div class="p1_tpc">处理</div>
				<div class="p1_cont p1_cont_p">
					<table style="width: 85%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
						<tr>
							<td width="13%" align="right" class="gray">
								跟进状态：<span style="color:red">*</span>
							</td>
							<td width="20%" align="left">
								<s:select list="#{'3':'电联','4':'到访','5':'认购','6':'签约'}" name="customerApplication.customerStatus" />
							</td>
							<td width="13%" align="right" class="gray">楼盘：</td>
							<td width="20%" align="left">
								<s:select list="houseList" name="customerApplication.houseId" listKey="id" listValue="projectName" />
							</td>
							<td width="13%" align="right" class="gray">客户有效性：<span style="color:red">*</span></td>
							<td align="left">
								<s:select list="#{'1':'有效客户','0':'无效客户','2':'无意向客户'}" name="customerApplication.effectType" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								客户等级：<span style="color:red">*</span>
							</td>
							<td align="left">
								<s:select list="#{'1':'A类客户','2':'B类客户','3':'C类客户','4':'D类客户','5':'E类客户' }" name="customerApplication.customerLevel" />
							</td>
							<td align="right" class="gray">
								下次跟进时间： <span style="color:red">*</span>
							</td>
							<td align="left">
								<s:textfield cssClass="timer" name="customerApplication.nextTime" readonly="readonly" /> 
							</td>
							<td align="right" class="gray">
								佣金套数：
							</td>
							<td align="left">
								<s:textfield name="customerApplication.houseCount" cssClass="validate[custom[integer]]" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								佣金单价：
							</td>
							<td align="left">
								<s:textfield name="customerApplication.housePrice" cssClass="validate[custom[integer],min[0],max[99999999]]" />
							</td>
							<td align="right" class="gray">
								经纪人维护人：
							</td>
							<td align="left">
								<s:textfield name="customerApplication.agentInfo.agentPerson" maxlength="6" />
							</td>
							<td align="right" class="gray">
								经纪人联系电话：
							</td>
							<td align="left">
								<s:textfield name="customerApplication.agentInfo.personPhone" cssClass="validate[custom[phone]]" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								置业顾问设置：
							</td>
							<td align="left" class="gray">
								<s:textfield name="customerApplication.consultantName" maxlength="6" />
							</td>
							<td align="right" class="gray">
								是否生成带看奖：
							</td>
							<td align="left">
								<input name="customerApplication.isLooked"  type="checkbox" />
							</td>
							<td align="right" class="gray">
								是否生成到访奖：
							</td>
							<td align="left">
								<input name="customerApplication.isArrived"  type="checkbox" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								描述备注：<span style="color:red">*</span>
							</td>
							<td align="left" colspan="5">
								<textarea rows="5" cols="100" name="customerApplication.remark" style="border:1px solid #AAA;line-height: 30px;padding: 0px 5px;font-family: 'Courier New','微软雅黑';"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="6" align="center"><input id="savebtn" type="submit" value="处理" class="btn_search" style="width:220px"/></td>
						</tr>
					</table>
				</div>
			</s:form>
			<div class="p1_tpc">客户信息</div>
			<div class="p1_cont p1_cont_p">
				<table style="width: 85%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
					<tr>
						<td width="10%" align="right" class="gray">
							推荐区域：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.houseInfo.areaInfo.areaName" />
						</td>
						<td width="10%" align="right" class="gray">
							推荐楼盘：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.houseInfo.projectName" />
						</td>
						<td width="10%" align="right" class="gray">
							客户姓名：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.customerName" />
						</td>
						<td width="10%" align="right" class="gray">
							客户电话：
						</td>
						<td align="left">
							<s:property value="customerApplication.customerDecimal" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							报备时间：
						</td>
						<td align="left">
							<s:date name="customerApplication.referTime" format="yyyy-MM-dd HH:mm" />
						</td>
						<td align="right" class="gray">
							自行带看：
						</td>
						<td align="left">
							<s:property value="%{customerApplication.selfLook == 1 ? '是' : '否'}" />
						</td>
						<td align="right" class="gray">
							有效性：
						</td>
						<td align="left">
							<s:property value="%{customerApplication.effectType == 1 ? '有效' : '无效'}" />
						</td>
						<td align="right" class="gray">
							最后跟进时间：
						</td>
						<td align="left">
							<s:date name="customerApplication.followTime" format="yyyy-MM-dd HH:mm" />
						</td>
					</tr>
					</tr>
						<td align="right" class="gray">
							最新跟进人：
						</td>
						<td align="left">
							<s:property value="customerApplication.duty.realName" />
						</td>
						<td align="right" class="gray">
							客户状态：
						</td>
						<td align="left">
							<s:if test="customerApplication.customerStatus == 1">
								未分配
							</s:if>
							<s:elseif test="customerApplication.customerStatus == 2">
								未处理
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 3">
								电联
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 4">
								到访
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 5">
								认购
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 6">
								签约
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 7">
								申请结佣
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 8">
								已结佣
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 9">
								申请提现
							</s:elseif>
							<s:elseif test="customerApplication.customerStatus == 10">
								提现成功
							</s:elseif>
						</td>
						<td align="right" class="gray">
							客户等级：
						</td>
						<td align="left">
							<s:if test="customerApplication.customerLevel == 1">
								A类客户
							</s:if>
							<s:elseif test="customerApplication.customerLevel == 2">
								B类客户
							</s:elseif>
							<s:elseif test="customerApplication.customerLevel == 3">
								C类客户
							</s:elseif>
							<s:elseif test="customerApplication.customerLevel == 4">
								D类客户
							</s:elseif>
							<s:elseif test="customerApplication.customerLevel == 5">
								E类客户
							</s:elseif>
							<s:else>未分类客户</s:else>
						</td>
						<td align="right" class="gray">
							下次跟进时间：
						</td>
						<td align="left">
							<s:date name="customerApplication.nextTime" format="yyyy-MM-dd HH:mm" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							联系经纪人：
						</td>
						<td align="left">
							&nbsp;
						</td>
						<td align="right" class="gray">
							申诉状态：
						</td>
						<td align="left">
							<s:if test="customerApplication.appealStatus == 1">
								已申诉
							</s:if>
							<s:elseif test="#item.appealStatus == 2">已处理</s:elseif>
							<s:else>未申诉</s:else>
						</td>
						<td align="right" class="gray">
							催办状态：
						</td>
						<td align="left">
							<s:if test="customerApplication.presStatus == 0">
								未催办
							</s:if>
							<s:else>
								已催办
							</s:else>
						</td>
						<td align="right" class="gray">
							结佣状态：
						</td>
						<td align="left">
							<s:property value="%{customerApplication.customerStatus lt 8 ? '未结佣' : '已结佣'}" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							亲自带看：
						</td>
						<td align="left">
							<s:property value="%{customerApplication.selfLook == 1 ? '是' : '否'}" />
						</td>
						<td align="right" class="gray">
							亲自邀约：
						</td>
						<td align="left">
							<s:property value="%{customerApplication.selfSend == 1 ? '是' : '否'}" />
						</td>
						<td align="right" class="gray">
							备注信息：
						</td>
						<td align="left" colspan="3">
							<s:property value="customerApplication.remark" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							最新跟进信息：
						</td>
						<td align="left" colspan="7">
							<s:iterator value="customerApplication.records" var="item" status="st">
								【<s:property value="#item.user.realName" />】【<s:date name="%{#item.operateTime}" format="yyyy-MM-dd HH:mm" />】
                                                                <s:if test="#item.operateType == 3">
								【跟进状态:电联】
								</s:if>
								<s:elseif test="#item.operateType == 4">
								【跟进状态:到访】
								</s:elseif>
								<s:elseif test="#item.operateType == 5">
								【跟进状态:认购】
								</s:elseif>
								<s:elseif test="#item.operateType == 6">
								【跟进状态:签约】
								</s:elseif>
                                                                【跟进备注：】【
								<s:property value="#item.operateContent" />】<br />
							</s:iterator>
						</td>
					</tr>
				</table>
			</div>
			<div class="p1_tpc">经纪人信息</div>
			<div class="p1_cont p1_cont_p">
				<table style="width: 85%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
					<tr>
						<td width="10%" align="right" class="gray">
							经纪人姓名：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.agentInfo.user.realName" />
						</td>
						<td width="10%" align="right" class="gray">
							经纪人电话：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.agentInfo.phoneDecimal" />
						</td>
						<td width="10%" align="right" class="gray">
							经纪人区域：
						</td>
						<td width="15%" align="left">
							<s:property value="customerApplication.agentInfo.workArea" />
						</td>
						<td width="10%" align="right" class="gray">
							所属门店/楼盘：
						</td>
						<td align="left">
							<s:property value="customerApplication.agentInfo.workSpace" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							经纪人昵称：
						</td>
						<td align="left">
							<s:property value="customerApplication.agentInfo.user.nickName" />
						</td>
						<td align="right" class="gray">
							最后一次报备时间：
						</td>
						<td align="left">
							<s:date name="customerApplication.agent.dealTime" format="yyyy-MM-dd HH:mm" />
						</td>
						<td align="right" class="gray">
							总报备数量：
						</td>
						<td align="left">
							<s:property value="customerApplication.agentInfo.customerCount" />
						</td>
						<td align="right" class="gray">
							案场接待置业顾问：
						</td>
						<td align="left">
							<s:property value="customerApplication.consultantName" />
						</td>
					</tr>
					<tr>
						<td align="right" class="gray">
							经纪人维护人员：
						</td>
						<td align="left">
							<s:property value="customerApplication.agentInfo.agentPerson" />
						</td>
						<td align="right" class="gray">
							经纪人维护人号码：
						</td>
						<td align="left" colspan="5">
							<s:property value="customerApplication.agentInfo.personPhone" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

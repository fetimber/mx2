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
			.tab_1 td {font-family:'Courier New','微软雅黑';line-height: 34px}
			.tab_1 tr {height:34px;}
			.input_1 {font-family:'Courier New','微软雅黑';width:230px}
		</style>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;经纪人管理&nbsp;>&nbsp;经纪人详情
		</div>
		<div class="m_w">
			<!--后台用户-->
			<s:form id="agent_form" action="agent!confirm" namespace="/admin" method="post">
				<s:hidden name="agentUser.id" />
				<s:hidden name="agentUser.user.id" />
				<s:hidden name="agentUser.cardFileid" />
				<s:hidden name="agentUser.idtFileid" />
				<s:hidden name="agentUser.realNameValidate"/>
				<div class="p1_tpc">
					经纪人信息
					<!-- 
					<input id="savebtn" type="button" value="审核通过" class="btn_search" style="margin-left:200px;" onclick="validate(1)"/>
					<input id="savebtn" type="button" value="审核拒绝" class="btn_search" style="margin-left:200px;" onclick="validate(0)"/>
					<input id="savebtn" type="submit" style="display:none"/>
					 -->
				</div>
				<div class="p1_cont p1_cont_p">
					<table style="width: 95%; margin-left: 15px ;min-width: 1660px" border="0" cellspacing="0" cellpadding="0" class="tab_1">
						<tr>
							<td width="10%" align="right" class="gray">
								姓名：
							</td>
							<td width="25%" align="left">
								<s:property value="agentUser.user.realName" />
							</td>
							<td width="10%" align="right" class="gray">
								电话：
							</td>
							<td width="25%" align="left">
								<s:property value="agentUser.phoneDecimal" />
							</td>
							<td width="10%" align="right" class="gray">
								注册时间：
							</td>
							<td align="left">
								<s:date name="agentUser.user.createTime" format="yyyy-MM-dd HH:mm" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								认证状态：
							</td>
							<td align="left">
								<s:if test="agentUser.realNameValidate > 0">已认证</s:if><s:else>未认证</s:else>
							</td>
							<td align="right" class="gray">
								推荐客户数：
							</td>
							<td align="left">
								<s:property value="agentUser.customerCount" />
							</td>
							<td align="right" class="gray">
								最近登录时间：
							</td>
							<td align="left">
								<s:date name="agentUser.user.lastLogintime" format="yyyy-MM-dd HH:mm" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								最近一次交互处理日期：
							</td>
							<td align="left">
								<s:date name="agentUser.dealTime" format="yyyy-MM-dd" />
							</td>
							<td align="right" class="gray">
								最后一次交互处理结果：
							</td>
							<td align="left">
								<s:property value="agentUser.dealContent" />
							</td>
							<td align="right" class="gray">
								经纪人维护人：
							</td>
							<td align="left">
								<s:property value="agentUser.agentPerson" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								最新跟进信息：
							</td>
							<td align="left" colspan="6">
								<s:iterator value="agentUser.records" var="item" status="st">
									<s:property value="#item.user.realName" />&nbsp;在&nbsp;<s:date name="%{#item.operateTime}" format="yyyy-MM-dd HH:mm" />&nbsp;进行操作：&nbsp;
									<s:property value="#item.operateContent" /><br />
								</s:iterator>
							</td>
					    </tr>
						<tr>
							<td align="right" class="gray">
								维护人号码：
							</td>
							<td align="left">
								<s:property value="agentUser.personPhone" />
							</td>
							<td align="right" class="gray">
								下次回访日期设定：
							</td>
							<td align="left">
								<s:date name="agentUser.nextTime" format="yyyy-MM-dd" />
							</td>
							<td align="right" class="gray">
								经纪人分组：
							</td>
							<td align="left">
								<s:property value="agentUser.agentGroup" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								经纪人微信昵称：
							</td>
							<td align="left">
								<s:property value="agentUser.user.nickName" />
							</td>
							<td align="right" class="gray">
								所属门店或楼盘：
							</td>
							<td align="left">
								<s:property value="agentUser.workSpace" />
							</td>
							<td align="right" class="gray">
								经纪人所属区域：
							</td>
							<td align="left">
								<s:property value="agentUser.workArea" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								经纪人来源：
							</td>
							<td align="left" colspan="5">
								<s:if test="null eq agentUser.source">
									--
								</s:if>
								<s:elseif test="agentUser.source eq 1">
									自主注册
								</s:elseif>
								<s:elseif test="agentUser.source eq 2">
									推荐注册
								</s:elseif>
								<s:elseif test="agentUser.source eq 3">
									线下推广
								</s:elseif>
								<s:elseif test="agentUser.source eq 4">
									其他方式
								</s:elseif>
							</td>
						</tr>
					    <tr>
							<td align="right" class="gray">
								身份证号：
							</td>
							<td align="left">
								<s:property value="agentUser.idtNum" />
							</td>
							<td align="right" class="gray">
								开户银行：
							</td>
							<td align="left">
								<s:property value="agentUser.bankName"/>
							</td>
							<td align="right" class="gray">
								银行卡号：
							</td>
							<td align="left">
								<s:property value="agentUser.bankAccount"/>
							</td>
						</tr>
						
						<tr>
							<td align="right" class="gray">
								身份证图片：
							</td>
							<td align="left" style="overflow: hidden">
								<img src="<s:property value="agentUser.idtFileInfo.filePath" default="resources/images/logo.png" />" alt=""  onload="AutoResizeImage(400,300,this);" />
							</td>
							<td align="right" class="gray">
								名片图片：
							</td>
							<td align="left" colspan="3" style="overflow: hidden;">
								<img src="<s:property value="agentUser.cardFileInfo.filePath" default="resources/images/logo.png" />" alt=""  onload="AutoResizeImage(400,300,this);"/>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>

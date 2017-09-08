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
			.input_1{width:160px;}
			.hasDatepicker{font-family:'Courier New','微软雅黑'}
			.ui-datepicker-calendar * {font-family:'Courier New','微软雅黑'}
			.tab1 td{font-family:'Courier New','微软雅黑'}
		</style>
		<script type="text/javascript">
			function _forward_page(page) {
				$(":hidden[name='page.current']").val(page);
				$("#agentsview").submit();
			}
			$(function() {
				$(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true
				});
				$("select").selectmenu({width:'172px'});
				$("#querybtn").bind("click",function() {
					 _forward_page(1);
				});
				var result = '<s:property value="#request.result" />';
				if(result == 'true'){
					$.dialog.tips('<s:property value="#request.message" />',2,'success.gif');
				} else if(result == 'false') {
					$.dialog.tips('<s:property value="#request.message" />',2,'error.gif');
				}
			});
		</script>
	</head>
	<body>
		<div class="home" style="min-width: 1702px;">
			<img src="resources/images/icon_home.png" width="20" height="20" />
			数据管理&nbsp;>&nbsp;经纪人管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<s:form action="agent!view" namespace="/admin" id="agentsview">
				<s:hidden name="page.current" />
				<div class="tab_check">
					<table class="tab1" width="100%" style="border:0;min-width: 1663px"> 
						<tr>
							<td align="right">请输入搜索关键字:</td>
							<td colspan="7"><s:textfield name="query.keyword" cssStyle="width:75%" cssClass="auto_tips input_1" alt="所属门店或楼盘、经纪人号码、区域、经纪人维护人员"></s:textfield> </td>
						</tr>
						<tr>
							<td width="13%" align="right">签约数量下限:</td>
							<td width="12%"><s:textfield name="query.signCountMin" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
							<td width="13%" align="right">签约数量上限:</td>
							<td width="12%"><s:textfield name="query.signCountMax" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
							<td width="13%" align="right">报备数量下限:</td>
							<td width="12%"><s:textfield name="query.reportCountMin" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
							<td width="13%" align="right">报备数量上限:</td>
							<td><s:textfield name="query.reportCountMax" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
						</tr>
						<tr>
							<td align="right">到访数量下限:</td>
							<td><s:textfield name="query.visitCountMin" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
							<td align="right">到访数量上限:</td>
							<td><s:textfield name="query.visitCountMax" cssClass="auto_tips input_1" alt="请输入一个数字" /></td>
							<td align="right">最近一次交互处理时间开始:</td>
							<td><input name="query.lastProcessTimeStart" type="text" class="input_1 timer" value="<s:date name="%{query.lastProcessTimeStart}" format="yyyy-MM-dd" />" /></td>
							<td align="right">最近一次交互处理时间结束:</td>
							<td><input name="query.lastProcessTimeEnd" type="text" class="input_1 timer" value="<s:date name="%{query.lastProcessTimeEnd}" format="yyyy-MM-dd" />" /></td>
						</tr>
						<tr>
							<td align="right">下次回访时间开始:</td>
							<td><input name="query.nextVisitTimeStart" type="text" class="input_1 timer" value="<s:date name="%{query.nextVisitTimeStart}" format="yyyy-MM-dd" />" /></td>
							<td align="right">下次回访时间结束:</td>
							<td><input name="query.nextVisitTimeEnd" type="text" class="input_1 timer" value="<s:date name="%{query.nextVisitTimeEnd}" format="yyyy-MM-dd" />" /></td>
							<td align="right">报备时间开始:</td>
							<td><input name="query.reportTimeStart" type="text" class="input_1 timer" value="<s:date name="%{query.reportTimeStart}" format="yyyy-MM-dd" />" /></td>
							<td align="right">报备时间结束:</td>
							<td><input name="query.reportTimeEnd" type="text" class="input_1 timer" value="<s:date name="%{query.reportTimeEnd}" format="yyyy-MM-dd" />" /></td>
						</tr>
						<tr>
							<td  align="right">请选择排序方式</td>
							<td colspan="3"><s:select name="query.order" list="#{'0':'默认排序',1:'签约数量',2:'报备数量',3:'到访数量',4:'最近一次交互处理时间',5:'下次回访时间' }"></s:select></td>
							<td colspan="2">&nbsp;</td>
							<td colspan="2" style="text-align: center;"><input id="querybtn" type="button" value="搜索" class="btn_search" style="width:170px;margin-right:35px" /><input type="button" value="重置" class="btn_search" style="width:170px" onclick="window.location.href='admin/agent!view'" /></td>
						</tr>
					</table>
				</div>
			</s:form>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1663px">
				<tbody>
					<tr>
						<th width="3%">序号</th>
						<th width="6%">
							经纪人姓名
						</th>
						<th width="9%">
							微信昵称
						</th>
						<th width="7%">
							电话
						</th>
						<th width="5%">
							状态
						</th>
						<th width="8%">
							工作区域
						</th>
						<th width="8%">
							门店楼盘
						</th>
						<th width="4%">
							报备数
						</th>
						<th width="4%">
							到访数
						</th>
						<th width="4%">
							签约数
						</th>
						<th width="7%">
							推荐人号码
						</th>
						<th width="9%">
							注册时间
						</th>
						<th width="8%">
							最近交互日期
						</th>
						<th width="8%">
							下次回访日期
						</th>
						<th>
							操作
						</th>
					</tr>
					<s:if test="null != page.beans && page.beans.size()>0">
						<s:iterator value="page.beans" var="item" status="status">
							<tr <s:if test="#status.odd != true">class="inter"</s:if>>
								<td align="center" valign="top">
									<s:property value="%{page.offset * (page.current - 1) + #status.count}" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.user.realName" default="--" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.user.nickName" default="--" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.phoneDecimal" default="--" />
								</td>
								<td align="center" valign="top">
									<s:if test="#item.realNameValidate > 0">
										已认证
									</s:if>
									<s:else>
										未认证
									</s:else>
								</td>
								<td align="center" valign="top">
									<s:property value="#item.workArea" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.workSpace" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.customerCount" default="0" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.arrivedCount" default="0" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.signCount" default="0" />
								</td>
								<td align="center" valign="top">
									<s:property value="#item.referNumber" default="--" />
								</td>
								<td align="center" valign="top">
									<s:date name="#item.user.createTime" format="yyyy-MM-dd HH:mm" />
								</td>
								<td align="center" valign="top">
									<s:date name="%{#item.dealTime}" format="yyyy-MM-dd" />
								</td>
								<td align="center" valign="top">
									<s:date name="%{#item.nextTime}" format="yyyy-MM-dd" />
								</td>
								<td align="center" valign="top">
									<a href="admin/agent!detail?agentUser.id=<s:property value="#item.id"/>">详情</a>｜<a href="admin/agent!history?agentUser.id=<s:property value="#item.id"/>">报备历史</a>｜<a href="admin/agent!check?agentUser.id=<s:property value="#item.id" />"><s:if test="#item.realNameValidate == 0 || #item.realNameValidate == null">审核修改</s:if><s:else>修改</s:else></a>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="11" align="center">
								<font style="color:#ff671c;">
									没查询到您想要的数据信息！！
								</font>
							</td>
						</tr>
					</s:else>
				</tbody>
			</table>
			<!--页码-->
			<div class="page">
				<s:include value="../common/page.jsp" />
			</div>
		</div>
	</body>
</html>

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
		<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
		<style type="text/css">
			.tab1 td{text-align: center; font-family: "Courier New","微软雅黑"}
			#base_frm_project_area-button{height: 30px;margin-left: 15px;}
		</style>
		<script type="text/javascript">
			$(function(){
				$("select").selectmenu({width:"180px"});
			});
			function delete_house(id,name){
				$.dialog.confirm("你确定要删除楼盘[" + name + "]吗？<br /><br />删除后，将不再显示此楼盘，请谨慎操作。", function(){
				   $.get("admin/house!delete_house",{"project.id":id},function(data){
					   eval("data=" + data);
					   if(data.result){
						   $.dialog.tips("数据操作成功",2,'success.gif',function(){
							   window.location.reload(true);
						   });
					   } else {
						   $.dialog.tips("服务器繁忙，数据操作失败，请稍后再试",2,'error.gif');
					   }
				   });
				});
			}
			function _forward_page(page){
				$("#page_current").val(page);
				$("#base_frm").submit();
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;楼盘管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check" style="min-width: 850px;">
				<s:form action="house" namespace="/admin" id="base_frm" style="float:left;">
					<s:textfield name="project.projectName" cssClass="auto_tips" alt="请输入楼盘名称" style="float:left; width:300px;border:1px solid #aaa;height:28px;padding:1px 5px;line-height:28px"></s:textfield>
					<s:select list="#request.areas" listKey="id" listValue="areaName" name="project.area" headerKey="" headerValue="请选择区域" style="height:30px"></s:select>
					<s:hidden name="page.current" id="page_current"></s:hidden>
				</s:form>
				<input type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)" />
				<input type="button" value="新增楼盘" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/house!add'" />
				<input type="button" value="区域管理" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/area'" />
			</div>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1680px">
				<tr>
					<th width="4%">
						序号
					</th>
					<th width="12%">
						楼盘名称
					</th>
					<th width="8%">
						区域
					</th>
					<th width="7%">
						单价
					</th>
					<th width="7%">
						更新时间
					</th>
					<th width="6%">
						项目经理
					</th>
					<th width="7%">
						经理电话
					</th>
					<th width="6%">
						佣金
					</th>
					<th width="6%">
						首次来访
					</th>
					<th width="6%">
						亲自看房
					</th>
					<th width="4%">
						主打
					</th>
					<th width="4%">
						需求
					</th>
					<th width="7%">
						面积
					</th>
					<th width="6%">
						成交指数
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="#request.page.beans" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td>
							<s:property value="%{#request.page.start + #st.count}" />
						</td>
						<td>
							<s:property value="#item.projectName" />
						</td>
						<td>
							<s:property value="#item.areaInfo.areaName" />
						</td>
						<td>
							<s:property value="#item.price" default="0" />元
						</td>
						<td>
							<s:date name="%{#item.updateTime}" format="yyyy-MM-dd" />
						</td>
						<td>
							<s:property value="#item.pmInfo.realName" />
						</td>
						<td>
							<s:property value="#item.pmInfo.phone" />
						</td>
						<td>
							<s:property value="#item.brokerage" default="0" />元
						</td>
						<td>
							<s:property value="#item.firstReward" default="0" />元
						</td>
						<td>
							<s:property value="#item.viewReward" default="0" />元
						</td>
						<td>
							<s:property value="%{#item.isMain == 1 ? '是' : '否'}" default="否" />
						</td>
						<td>
							<s:property value="%{#item.reqType == 1 ? '刚需' : '改善'}" default="刚需" />
						</td>
						<td>
							<s:property value="#item.downArea" default="0" />m²-<s:property value="#item.upArea" default="0" />m²
						</td>
						<td>
							<s:property value="#item.dealPoint" default="0" />
						</td>
						<td>
							<a href="javascript:delete_house(<s:property value="#item.id" />,'<s:property value="#item.projectName" />')">删除</a>|<a href="admin/house!edit?project.id=<s:property value="#item.id" />">修改</a>|<a href="admin/house!config?project.id=<s:property value="#item.id" />">周边配套</a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<!--页码-->
			<div class="page">
			<s:include value="../common/page.jsp"></s:include>
			</div>
		</div>
	</body>
</html>
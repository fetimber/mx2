<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<style type="text/css">
		body {padding-top: 20px;}
		*{font-size: 13px;font-family: "Courier New","微软雅黑"}
		td , th {text-align: center;height: 20px;line-height: 20px; border: 1px solid #666}
	</style>    
	<script type="text/javascript">
		$(function(){
			$("#cbx_all").bind("change",function(){
				var is_checked = $(this).prop("checked");
				$("input:checkbox").not("#cbx_all").each(function(){
					$(this).prop("checked",is_checked)
				});
			});
			var api = frameElement.api, W = api.opener;
			api.button({name:'保存',focus:true,callback:function(){
				var checked = new Array();
				$(".cbx_checked").each(function(){
					if($(this).prop("checked")){
						checked.push($(this).val());
					}
				});
				
				W.auth_ok(checked);
			}},{name:'取消',callback:function(){}});
		});
	</script>
  </head>
  <body style="overflow: hidden;">
	<s:form action="user!role_auth_save" namespace="/admin">
		<table border="0" cellspacing="0" cellpadding="0" class="tab6" style="width:650px">
			<tr>
				<th width="12%"><input type="checkbox" id="cbx_all" /></th>
				<th width="15%">序号</th>
				<th width="20%">菜单名称</th>
				<th>菜单地址</th>
			</tr>
			<s:iterator value="#request.menus" var="item" status="st">
				<s:if test="#item.menuName != '权限管理' and  #item.menuName != '角色管理'">
				<tr>
					<td><input type="checkbox" value="<s:property value="#item.id" />" class="cbx_checked" <s:if test="1==#item.sortDecimal">checked</s:if> /></td>
					<td><s:property value="#st.count" /></td>
					<td><s:property value="#item.menuName" /></td>
					<td><s:property value="#item.menuUrl" /></td>
				</tr>
				</s:if>
			</s:iterator>
		</table>
	</s:form>
</body>
</html>

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
			*{font-family: "Courier New","微软雅黑"}
			.tab1 td{text-align: center;}
			.hand {cursor :hand}
		</style>
		<script type="text/javascript">
			$(function(){
				$("select").selectmenu({width:"180px"});
				$(".tab1 tr:gt(0)").each(function(){
					var td = $(this).find("td:eq(3)");
					var all_ctx = td.text();
					var ctx = all_ctx;
					if(ctx.length > 40){
						ctx = ctx.substring(0,40) + "....";
						td.text(ctx);
						var a = $("<a>").attr("href","javascript:void(0)").text("查看全文").addClass("hand").bind("click",function(){
							$.dialog({
							    fixed: true,
							    content: all_ctx,
							    title:'周边内容',
							    width:'400px',
							    ok:function(){},
							    max:false,
							    min:false
							});
						});
						td.append(a);
					}
				});
			});
			function delete_config(id,name){
				$.dialog.confirm("你确定要删除周边信息[" + name + "]吗？<br /><br />删除后，将不再显示此周边信息，请谨慎操作。", function(){
				   $.get("admin/house!config_delete",{"config.id":id},function(data){
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
			function show_img(imgs){
				if(undefined == imgs || null == imgs){
					return;
				}
				var ct = "";
				for(var i = 0; i < imgs.length; i++){
					ct += "<img src='" + imgs[i] + "' />";
					if(i + 1 < imgs.length){
						ct += ",";
					}
				}
				var img = $.dialog({
				    title: '周边图片',
				    content: ct,
				    padding: 0,
				    fixed: false,
				    height:'500px',
				    width:'500px'
				});
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;楼盘管理&nbsp;>&nbsp;周边配套
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check">
				<input type="button" value="返回楼盘管理" class="btn_search" style="margin-left:10px;" onclick="location.href='admin/house'" />
				<input type="button" value="新增周边" class="btn_search" style="margin-left:10px;" onclick="location.href='admin/house!config_edit?config.projectId=<s:property value="project.id" />'" />
				项目名称：<s:property value="project.projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
				区域：<s:property value="project.areaInfo.areaName" />&nbsp;&nbsp;&nbsp;&nbsp;
				简介：<s:property value="project.projectSummary" />&nbsp;&nbsp;&nbsp;&nbsp;
				单价：<s:property value="project.price" />元&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1280px">
				<tr>
					<th width="4%">
						序号
					</th>
					<th width="6%">
						周边名称
					</th>
					<th width="15%">
						标题
					</th>
					<th>
						配套内容
					</th>
					<th width="10%">
						更新时间
					</th>
					<th width="6%">
						图片数量
					</th>
					<th width="11%">
						操作
					</th>
				</tr>
				<s:iterator value="#request.configs" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td><s:property value="#st.count" /></td>
						<td><s:property value="#item.configName" /></td>
						<td><s:property value="#item.configTitle" /></td>
						<td><s:property value="#item.configContent" /></td>
						<td><s:date name="%{#item.updateTime}" format="yyyy-MM-dd HH:mm" /></td>
						<td><s:property value="%{null == #item.files ? 0 : #item.files.size()}" /></td>
						<td>
							<a href="admin/house!config_edit?config.id=<s:property value="#item.id" />">编辑</a>|<a href="javascript:delete_config(<s:property value="#item.id" />,'<s:property value="#item.configName" />')">删除</a><s:if test="null !=#item.files and !#item.files.isEmpty()">|<a href="javascript:show_img([<s:iterator value="#item.files" var="img" status="st1">'<s:property value="#img.filePath" />'<s:if test="!#st1.last">,</s:if></s:iterator>])">查看图片</a></s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>
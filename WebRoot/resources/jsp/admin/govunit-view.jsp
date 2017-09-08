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
			
			function _forward_page(page){
				$("#page_current").val(page);
				$("#base_frm").submit();
			}
			
			function delete_unit(id,name){
			    $.dialog.confirm("你确定要删除单位[" + name + "]吗？<br /><br />删除后，将不再显示此单位，请谨慎操作。", function(){
				   $.get("admin/govunit!delete",{"unit.id":id},function(data){
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
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;单位管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check" style="min-width: 850px;">
				<s:form action="govunit!view" namespace="/admin" id="base_frm" style="float:left;">
					<s:textfield name="unit.unitName" cssClass="auto_tips" alt="请输入单位名称" style="float:left; width:150px;border:1px solid #aaa;height:28px;padding:1px 5px;line-height:28px"></s:textfield>
					<s:hidden name="page.current" id="page_current"></s:hidden>
				</s:form>
				<input type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)" />
				<input type="button" value="新增单位" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/govunit!add'" />
				
				<s:if test="1 == #session.userinfo_in_session.roleId || 11 == #session.userinfo_in_session.roleId">
				  <input type="button" value="市级单位管理" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/area'" />
			    </s:if>
			</div>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
				<tr>
					<th width="10%">
						序号
					</th>
					<th width="25%">
						单位名称
					</th>
					<th width="15%">
						所属市级单位
					</th>
					<th width="15%">
						创建时间
					</th>
					<th width="20%">
						负责人
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
							<s:property value="#item.unitName" />
						</td>
						<td>
							<s:property value="#item.cityInfo.cityName" />
						</td>
						<td>
							<s:date name="%{#item.joinTime}" format="yyyy-MM-dd" />
						</td>

						<td>
							<s:property value="#item.unitDuty" />
						</td>
						
						<td>

							<a href="javascript:delete_unit(<s:property value="#item.id" />,'<s:property value="#item.unitName" />')">删除</a>
 						|	<a href="admin/govunit!add?unit.id=<s:property value="#item.id" />">修改</a> 
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
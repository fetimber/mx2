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
			
			function delete_worker(id,name){
			    $.dialog.confirm("你确定要删除职工[" + name + "]吗？<br /><br />删除后，将不再显示此职工，请谨慎操作。", function(){
				   $.get("admin/govworker!delete",{"worker.id":id},function(data){
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
			<img src="resources/images/icon_home.png" width="20" height="20" />会员库&nbsp;>&nbsp;单位会员管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check" style="min-width: 850px;">
				<s:form action="govworker!view" namespace="/admin" id="base_frm" style="float:left;">
					<s:textfield name="worker.workerName" cssClass="auto_tips" alt="请输入员工名称" style="float:left; width:300px;border:1px solid #aaa;height:28px;padding:1px 5px;line-height:28px"></s:textfield>
					
					<s:hidden name="page.current" id="page_current"></s:hidden>
				</s:form>
				<input type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)" />
				<input type="button" value="新增员工" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/govworker!add'" />
				
			</div>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
				<tr>
					<th width="5%">
						序号
					</th>
					<th width="10%">
						姓名
					</th>
					<th width="10%">
						单位
					</th>
					<th width="5%">
						性别
					</th>
					<th width="5%">
						年龄
					</th>
					<th width="10%">
						身份证号
					</th>
					<th width="10%">
						地址
					</th>
					<th width="10%">
						电话
					</th>
					<th width="10%">
						备注荣誉
					</th>
					<th width="13%">
						是否为困难职工
					</th>
					<th width="15%">
						操作
					</th>
				</tr>
				<s:iterator value="#request.page.beans" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td>
							<s:property value="%{#request.page.start + #st.count}" />
						</td>
						<td>
							<s:property value="#item.workerName" />
						</td>
						<td>
							<s:property value="#item.unitInfo.unitName" />
						</td>
						<td>
							<s:property value="#item.workerSex" />
						</td>
						<td>
							<s:property value="#item.workerAge" />
						</td>
						<td>
							<s:property value="#item.workerIdnumber" />
						</td>
						<td>
							<s:property value="#item.workerAddress" />
						</td>
						<td>
							<s:property value="#item.workerPhone" />
						</td>
						<td>
							<s:property value="#item.honorRemark" />
						</td>
						<td>
					    <s:if test="#item.isHard == 0 || #item.isHard == null">
							否
						</s:if>
						<s:if test="#item.isHard == 1">
							是
						</s:if>
						</td>
						<td>
                            <a href="javascript:delete_worker(<s:property value="#item.id" />,'<s:property value="#item.workerName" />')">删除</a>	
						|	<a href="admin/govworker!add?worker.id=<s:property value="#item.id" />">修改</a>
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
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
			* {font-family:"Courier New","微软雅黑"}
		</style>
		<script type="text/javascript">
			var big_pictures = new Array();
			var small_pictures = new Array();
			var price_pictures = new Array();
			$(function() {
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				});
				
				$("select").selectmenu({width:'440px'});
				
			});
			
		
		</script>
	</head>
	<body style="min-width: 1700px;">
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;门店管理&nbsp;>&nbsp;
			
			<s:if test="null == store"> 
			     新增门店信息
			</s:if>
			<s:else>
			     修改门店信息
			</s:else>
			
		</div>
		<s:form action="agent!store_save" namespace="/admin" method="post" id="base_frm">
		     <s:hidden name="store.id"></s:hidden>
			<div class="hid_files_div">
			
			</div>
			
			<table width="40%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 400px;float:left;">
				<tr>
					<td width="16%" align="right">
						门店名称
					</td>
					<td width="84%">
						<s:textfield name="store.storeName" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[100],ajax[_ajax_store_name]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入门店的名称，4-100个字符，不限制符号
						</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						门店地址
					</td>
					<td>
						<s:textfield name="store.storeAddress" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[200]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						管理员联系方式
					</td>
					<td>
						<s:textfield name="store.adminPhone" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[60]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<s:if test="null != #request.message">
					<tr>
						<td colspan="2">
							<span style="float:left;margin-left:232px"><font color="red"><s:property value="#request.message" /></font></span>
						</td>
					</tr>
				</s:if>
			</table>
			
			<div class="clear"></div>
			<p align="center" style="margin:20px 0 0 -240px;"><input type="submit" name="button" id="button" value="保存门店信息" class="btn_tj btn_tj_w1" style="width:430px"/></p>
		</s:form>

	</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath %>" />
<title>房小帅微信服务号后台管理系统</title>
<link href="resources/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="error">
	<s:if test="#request.result">
		<div class="error_txt5"><img src="resources/images/su_img1.png" width="79" height="67" />数据保存成功，您可以继续以下操作</div>
		<div class="error_txt3"><a href="<s:property value="#request.success_url" />"><s:property value="#request.success_name" /></a></div>
	</s:if>
	<s:else>
		<div class="error_txt5"><img src="resources/images/su_img1.png" width="79" height="67" />数据保存失败，可能是因为服务器正在繁忙</div>
		<div class="error_txt2">如果有需要请联系系统管理员</div>
	</s:else>
</div> 
</html>

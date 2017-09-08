<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>联系我们</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8"
			http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
			name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		


	</head>
	<body class="bg">
		<div class="detail_part">
			<p class="detail_h">
				客服热线
			</p>
			<p class="hotline">
				400-8888-888
			</p>
		</div>
	</body>
</html>

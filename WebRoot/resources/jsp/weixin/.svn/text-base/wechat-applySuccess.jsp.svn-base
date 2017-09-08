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
		<title>提交成功</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script type="text/javascript">
			function toMyMoney(){
				window.location.href = "weixin/wechat!myBrokerage";
			}
		</script>
	</head>
	<body class="bg">
		<div class="result">
			<p>
				<img src="resources/images/img_y.png" width="40" height="40" />
				您已提交成功！请等待审核
			</p>
			<div>
				<input type="button" value="返回我的佣金" class="btn_zc" onclick="toMyMoney()"/>		
			</div>
		</div>
	</body>
</html>

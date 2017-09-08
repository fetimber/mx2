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
		<title>催办成功</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script type="text/javascript">
			function toMyMoney(){
				var cid = document.getElementById("cid").value;//$.trim($("#cid").val());
				window.location.href = "weixin/wechat!customDetail?cId="+cid;
			}
		</script>
	</head>
	<body class="bg">
		<div class="part_3">
			<div class="tips_cont">
				<p class="su_img1">
					<img src="resources/images/su_img1.png" width="79" height="67" />
				</p>
				<p class="su_txt">
					√ 已催办
				</p>
			</div>
			<input type="button" class="btn_zc" value="返回上一页" onclick="toMyMoney()"/>
			<input type="hidden" id="cid" value="<s:property value="#request.cId" />"/>
		</div>
	</body>
</html>

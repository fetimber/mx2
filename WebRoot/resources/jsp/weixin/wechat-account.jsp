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
		<title>宿舍楼列表</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8"
			http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<style type="text/css">
		 .a1{color: #fff;
		    
		 }
		 .a1:visited{
		   color:#000;
		 }
		</style>
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  APP ={
        	   myCustomUrl : "weixin/wechat!myCustom",                //登录url
               detailUrl :   "weixin/wechat!customDetail",//用户的openId
               sucUrl :  ""                        //登录成功后跳转url
        }
       </script>

	</head>
	<body style="background: #f0f0f0;">
		<div class="acc_head">
			<div>
				<img src="resources/images/img_head.png" class="acc_img1" />
				<p class="acc_info1">
					<s:property value="#request.sysUser.loginName" />&nbsp;
					<s:if test="#request.agentUser.realNameValidate == 1 || #request.agentUser.realNameValidate == 2">
					    <img src="resources/images/icon_v.png" class="vip" />
					</s:if>
				</p>
			</div>
<!-- 			<div class="acc_count"> -->
<!-- 				<dl style="border-right: 1px solid #fff;"> -->
<!-- 					<dd> -->
<!-- 						<s:property value="#request.agentUser.customerCount" /> -->
<!-- 					</dd> -->
<!-- 					<dt> -->
<!-- 						推荐客户数 -->
<!-- 					</dt> -->
<!-- 				</dl> -->
<!-- 				<dl style="border-right: 1px solid #fff;"> -->
<!-- 					<dd> -->
<!-- 						<s:property value="#request.agentUser.account.total" /> -->
<!-- 					</dd> -->
<!-- 					<dt> -->
<!-- 						已结佣金总额(元) -->
<!-- 					</dt> -->
<!-- 				</dl> -->
<!-- 				<dl> -->
<!-- 					<dd> -->
<!-- 						<a style="color: #fff;" href="weixin/wechat!myRefersList" class="a1"><s:property value="#request.agentUser.referCount" /></a> -->
<!-- 					</dd> -->
<!-- 					<dt> -->
<!-- 						<a style="color: #fff;" href="weixin/wechat!myRefersList" class="a1">推荐经纪人注册</a> -->
<!-- 					</dt> -->
<!-- 				</dl> -->
<!-- 			</div> -->
		</div>
		<div class="acc_part1">
		    <div class="acc_lists">
			<dl class="b_dt">
				<dd>
					<a href="weixin/wechat!scan"><img src="resources/images/acc_4.png" /></a>
				</dd>
				<dt>
					<a href="weixin/wechat!scan">扫一扫</a>
				</dt>
			</dl>
		    </div>
		    
		    <div class="acc_lists">
			 <dl class="b_dt">
				<dd>
					<a href="weixin/wechat!housesPage?buildingno=5"><img src="resources/images/acc_4.png" /></a>
				</dd>
				<dt>
					<a href="weixin/wechat!housesPage?buildingno=5">5号楼</a>
				</dt>
			 </dl>
		    </div>
		    
		    
			<div class="acc_lists">
				<dl class="b_dt">
					<dd>
						<a href="weixin/wechat!housesPage?buildingno=4"><img src="resources/images/acc_1.png" /></a>
					</dd>
					<dt>
						<a href="weixin/wechat!housesPage?buildingno=4">4号楼</a>
					</dt>
				</dl>
			</div>
			<div class="acc_lists">
				<dl class="b_dl b_dt ">
					<dd>
						<a href="weixin/wechat!housesPage?buildingno=3"><img src="resources/images/acc_2.png" /></a>
					</dd>
					<dt>
						<a href="weixin/wechat!housesPage?buildingno=3">3号楼</a>
					</dt>
				</dl>
			</div>
			<div class="acc_lists">
				<dl class="b_dt">
					<dd>
						<a href="weixin/wechat!housesPage?buildingno=2"><img src="resources/images/acc_5.png" alt="" /></a>
					</dd>
					<dt>
						<a href="weixin/wechat!housesPage?buildingno=2">2号楼</a>
					</dt>
				</dl>
			</div>
			<div class="acc_lists">
				<dl class="b_dl b_dt">
					<dd>
						<a href="weixin/wechat!housesPage?buildingno=1"><img src="resources/images/acc_4.png" /></a>
					</dd>
					<dt>
						<a href="weixin/wechat!housesPage?buildingno=1">1号楼</a>
					</dt>
				</dl>
			</div>
			
			
			<div class="clear"></div>
		</div>
	</body>
</html>

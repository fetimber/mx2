<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>北汽宿舍管理系统</title>
	<meta charset="utf-8">
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
    <meta content="telephone=no, address=no" name="format-detection">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
	<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
	<script src="resources/weixin/lib_cmd/sea.js"></script>
    <script>
        var  APP ={
               loginUrl : "weixin/wechat!login",         //登录url
               openId :   "",//用户的openId
               sucUrl :   "weixin/wechat!myAccount"         //登录成功后跳转url
        }
    </script>
    
     <script>

        (function(l){
            seajs.config({
                base:"<%=basePath%>/resources/weixin",
                map:[
                    [".js", (l&&l[1]||"")+".js?v=044"]
                ]
            });
            //
            seajs.use("<%=basePath%>resources/weixin/js_cmd/login.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
	
  </head>
	<body class="login_bg">
		<div class="login_logo">
			<img src="resources/images/img_head2.png" />
		</div>
		<div style="padding: 0 32px;">
		    <p class="wregis">
				<input id="reg" type="button" value="我要注册" />
			</p>
			<div class="login_input" style="margin-top:-16px;">
				<div class="login_input1">
					<input type="tel" id="userName" name="userName"
						placeholder="请输入手机号码" />
				</div>
			</div>
			<div class="login_input">
				<div class="login_input1">
					<input id="pwd" name="pwd" type="password" placeholder="请输入密码" />
				</div>
			</div>
			<div class="login_btn">
				<input id="sub" type="button" value="登录" />
			</div>
			
		</div>
	</body>
</html>

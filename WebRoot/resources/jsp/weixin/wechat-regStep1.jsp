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
    <title>注册</title>
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
               sucUrl :  "weixin/wechat!myAccount",  //注册成功后跳转url
               sendMsgUrl : "weixin/wechat!sendRegMsg",//发送短信验证码url
               validMsgUrl: "weixin/wechat!validateRegMsg",//验证短信验证码url
               registUrl : "weixin/wechat!register"
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/regStep1.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body class="bg">
		<div class="part_2">
			<ul class="part_st">
				<li class="input_g ">
					
					<img src="resources/images/icon2.png" alt="" class="input_icon" />
					<div class="input_ab"><input name="phone" id="phone"  type="tel" class="input_aa" placeholder="请输入手机号码" /></div>
				</li>
				<li class="input_g" style="border-top:1px solid #eee;border-bottom:1px solid #eee;">
					<img src="resources/images/icon3.png" alt="" class="input_icon" />
					<div class="input_ab"><input id="pwd" name="pwd" type="password" class="input_aa" placeholder="请输入密码"/></div>
				</li>
				<li class="input_g" style="margin-bottom: 8px;">
					<img src="resources/images/icon4.png" alt="" class="input_icon" />
					<div class="input_ab"><input id="repwd" name="repwd" type="password" class="input_aa" placeholder="请再次输入密码" /></div>
				</li>
				
			</ul>
<!-- 			<div class="input_g" style="background: none;"> -->
<!-- 					<img src="resources/images/icon9.png" alt="" class="input_icon" /> -->
<!-- 					<input id="yzm" name="yzm" type="text" class="input_yzm" placeholder="验证码" /> -->
<!-- 					<span class="getyzm_get" id="getyzm" style="cursor: pointer;">获取验证码</span> -->
<!-- 					<div class="clear"></div> -->
<!-- 			</div> -->
		</div>
		<div style="padding: 0 32px;">
		    <input type="hidden" id="openId"  value="<s:property value="#request.openId" />"/>
			<input type="button" class="btn_zc" value="同意并注册" />
			<div style="margin-top: 15px;">
		      &nbsp;
		    </div>
		</div>
		
		
	</body>
</html>

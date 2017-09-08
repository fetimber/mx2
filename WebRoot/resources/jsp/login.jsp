<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<s:include value="common/meta.jsp" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<!--    <link rel="stylesheet" type="text/css" href="resources/css/style_login.css"></link> -->
<script>
$(function(){

	$(".auto_tips_1").each(function(){
		if($(this).attr("type") == "text"){
			if($(this).val() == '' || $(this).val() == $(this).attr("alt")){
				var alt = $(this).attr('alt');
				$(this).val(alt).css('color','#AAA').css("font-family","'Courier New','微软雅黑'");
			}
		} else if ($(this).attr("type") == "password") {
			var that = $(this);
			var html = that.prop("outerHTML").replace("password","text");
			var element = $(html).attr("id",that.attr("id") + "_text").attr("name",that.attr("name")+ "_text");
			element.val(element.attr('alt')).css('color','#AAA').css("font-family","'Courier New','微软雅黑'");
			element.appendTo(that.parent());
			that.hide();
			element.unbind("focus").bind("focus",function(){
				$(this).hide();
				that.show().focus().val('').blur(function(){
					if($(this).val() == $(this).attr("alt")){
						$(this).hide();
						element.show();
					}
				});
			});
		}
	}).each(function(){
		$(this).bind("focus",function(){
			if($(this).val() == $(this).attr('alt')){
				$(this).val('').css('color','#FFF');
			}
		}).bind("blur",function(){
			if($(this).val() == ''){
				$(this).val($(this).attr('alt')).css('color','#AAA').css("font-family","'Courier New','微软雅黑'");
			}
		}).trigger("blur");
	});
	

	$("form").each(function(){
		$(this).bind("submit",function(){
			$(this).find("input:text").each(function(){
				if($(this).hasClass('auto_tips') && $(this).val() == $(this).attr('alt')){
					$(this).val('');
				}
			});
		});
	});
	
	
			$(".login_yzm").attr("src","captcha").bind("click",function(){
				this.src = 'captcha?_='.concat(Math.random());
				$("input:text[name='captcha']").focus();
			})
	
});
</script>
<style type="text/css">
	input {font-color:#FFF}

</style>
</head>



<body class="login_bg">
  <s:form action="login!confirm"  method="POST" id="login_form">
  <div class="login">
   <p style="color:#fff; font-size:28px;">
       江苏省交通运输工会管理信息系统
   </p>
  <p>
     <input type="text" name="user.loginName" class="login_input auto_tips_1" alt="请输入您的用户名" autocomplete="off"/>
  <p>
  <p>
     <input type="password" name="user.pwdCode"  class="login_input auto_tips_1" style="border-top:0" alt="请输入您的密码"/>
  </p>
   <p>
     <br/>
     <s:textfield name="captcha" cssClass="login_input_yzm validate[required,custom[onlyLetterNumber]]" style="height:34px" value="输入验证码"
      onmouseout="this.style.borderColor=''" onfocus="if (value =='输入验证码'){value =''}" onblur="if (value ==''){value='输入验证码'}"></s:textfield>
	 <img width="155" height="40" class="login_yzm" />
   
  </p>
  <br/>

  <p>
     <input type="submit" value="登录" class="login_btn"/>
  </p>


  <p class="f_pwd" style="margin-top:14px"><font color="red" style="font-size: 16px"><s:property value="#request.message" /> </font></p>
  </s:form>
  <p class="login_copy"> Copyright 2016 版权所有 江苏省交通运输工会</p>
</div>
</body>
</html>
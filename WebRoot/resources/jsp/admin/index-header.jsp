<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"></link>
</head>
<body>

<div class="top">
<!--     <img src="resources/images/head_tpc.png" width="199" height="20" class="top_tpc"/>  -->
	<ul class="top_tpc"> 
	                    &nbsp;&nbsp;&nbsp;&nbsp;角色名：<s:property value="#session.userinfo_in_session.roleInfo.roleName"/> 
	                     <s:if test="#session.userinfo_in_session.roleId == 1">
	                     
	                     </s:if>
	                     <s:if test="#session.userinfo_in_session.roleId == 11">
	                     
	                     </s:if>
	                     <s:if test="#session.userinfo_in_session.roleId == 12">
	                      &nbsp;&nbsp;&nbsp;&nbsp;市级单位：<s:property value="#session.userinfo_in_session.cityInfo.cityName"/> 
	                     </s:if>
	                     <s:if test="#session.userinfo_in_session.roleId == 13">
	                    &nbsp;&nbsp;&nbsp;&nbsp; 单位名称：<s:property value="#session.userinfo_in_session.unitInfo.unitName"/>
	                    &nbsp;&nbsp;&nbsp;&nbsp; 市级单位：<s:property value="#session.userinfo_in_session.cityInfo.cityName"/> 
	                     </s:if>
	                     &nbsp;&nbsp;&nbsp;&nbsp;登录名：   <s:property value="#session.userinfo_in_session.loginName"/> 
	            
	                   
	</ul>
	<div class="top_r">
	     
 		 <span><a href="admin/user!password" class="top_pwd" target="viewmain"><img src="resources/images/head_pwd.png" width="20" height="20" />修改密码</a></span>
 		 
<!--         <a href="do?id=4" target="viewmain">客户管理</a> -->
        <span class="exit"><a href="login!out" target="main_frm"><img src="resources/images/head_exit.png" width="20" height="20" /></a></span>
    </div>
</div>

</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>江苏省交通运输工会管理信息系统</title>
		<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<link rel="stylesheet" type="text/css" href="resources/css/style.css"></link>
</script>
</head>
<frameset cols="200,*" framespacing="0" frameborder="no" border="0" noresize="noresize" id="main_frm" name="main_frm">
  <frame src="admin/index!left" name="left" noresize="noresize" marginwidth="0" marginheight="0">
  <frameset rows="60,*,40" framespacing="0" border="0" noresize="noresize">
    <frame src="admin/index!header" name="top" marginwidth="0" marginheight="0" frameborder="no" noresize="noresize" />
    <frame src="admin/user!main" id="view_iframe" name="viewmain" noresize="noresize" marginwidth="0" marginheight="0" />
    <frame src="admin/index!bottom" name="copy" marginwidth="0" marginheight="0" frameborder="no" noresize="noresize" scrolling="no" />
  </frameset>
</frameset>
</html>

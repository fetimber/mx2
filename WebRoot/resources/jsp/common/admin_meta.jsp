<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="X-UA-Compatible" content="IE=10">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="resources/css/admin.css"></link>
<link rel="stylesheet" type="text/css" href="resources/js/jquery-ui/jquery-ui.css"></link>
<link rel="stylesheet" type="text/css" href="resources/js/validation/css/validationEngine.jquery.css"></link>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.form.min.js"></script>
<script type="text/javascript" src="resources/js/dialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/validation/js/jquery.validationEngine.js" charset='utf-8'></script>
<script type="text/javascript" src="resources/js/validation/js/jquery.validationEngine-zh_CN.js" charset='utf-8'></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui/external/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui/external/jquery.ui.datepicker-zh-CN.js" charset='utf-8'></script>
<script type="text/javascript" src="resources/js/highchart/highcharts.js"></script>
<script type="text/javascript" src="resources/js/highchart/highcharts-zh-CN.js" charset='utf-8' charset='utf-8'></script>

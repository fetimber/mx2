<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
	<head>
	<base href="<%=basePath%>">
	<title>扫一扫</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
	  
	<script src="resources/js/twocode/jquery-1.9.1.js"></script>
	<script src="resources/js/twocode/html5-qrcode.js"></script>
	<script type="text/javascript">
	  $(document).ready(function(){
	    $('#reader').html5_qrcode(function(data){
	        $('#read').html(data);
	        //alert('解析成功啦')
	        //alert(data);
            var rommId = data;
            var buildno =  rommId.substr(0);
            window.location.href = "weixin/wechat!recommendPage?hid=1&roomcode="+ rommId +"&buildno="+ buildno;
	      },
	      function(error){
	        $('#read_error').html(error);
	      }, function(videoError){
	        $('#vid_error').html(videoError);
	      }
	    );
	  });
	</script>

    </head>
   <body class="bg" style="text-align:center;">
      <div class="center" id="reader" style="width:300px;height:250px; background:black;margin-left: 50px;margin-top: 10px">
	  <video id="html5_qrcode_video" height="250px" width="300px"></video>
	  <canvas id="qr-canvas" width="298px" height="248px" style="display:none;"></canvas>
	</div>
</body>
</html>
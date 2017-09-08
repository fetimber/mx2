
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
   <base href="<%=basePath%>">
	<title>HTML5 QR code Reader</title>
  </head>
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
  <body>

   

<div class="center" id="reader" style="width:300px;height:250px; background:black;">
  <video id="html5_qrcode_video" height="250px" width="300px"></video>
  <canvas id="qr-canvas" width="298px" height="248px" style="display:none;"></canvas>
</div>



</body></html>
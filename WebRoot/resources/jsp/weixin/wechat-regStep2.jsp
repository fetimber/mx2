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
    <title>注册成功</title>
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
               speAgent : "weixin/wechat!login"               //注册专业经纪人
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/regStep2.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body>
		<div class="part_pr">
			<div class="sel_reg" align="center">
				<img src="resources/images/img_hi.png" width="56" height="44" />
				<div class="reg_txt1">
					欢迎加入房小帅！
				</div>
				<div class="reg_txt2">
					您已注册成功！
				</div>
				<div class="reg_txta">
					<p>
						如果
					</p>
					<p class="reg_txt4">
						您需要享有小帅更多服务例如
					</p>
					<p class="reg_txt3">
						优先跟进您的客户；邀您参与更多活动
					</p>
					<p class="reg_txt3">
						您可以推荐经纪人朋友注册，获得推荐奖
					</p>
					<p class="reg_txt3">
						意外获得礼品的惊喜；参与抽奖的机会
					</p>
					<p class="reg_txt3">
						……
					</p>
				</div>
				<div class="reg_txt5">
				<span style="font-size:12px;">请继续注册成为</span>&nbsp;
					<a href="javascript:;">专业经纪人<img src="resources/images/icon_v.png" width="32" height="32"  class="icon_v"/> </a>
				</div>
				<div class="arrow_2"><img src="resources/images/arrow2.png" width="18" height="18" /></div>
			</div>
			<div><input type="button" class="btn_reg" value="继续注册专业经纪人" style="margin-top:24px" /></div>
			<div class="regis_go">注册完毕 &gt; <a href="weixin/wechat!myAccount">去逛逛</a></div>
		</div>
	</body>
</html>

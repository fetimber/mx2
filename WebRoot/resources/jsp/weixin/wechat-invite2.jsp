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
    <title>个人中心</title>
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
        	   acceptUrl : "weixin/wechat!acceptStore",     //接收邀请url
        	   refuseUrl : "weixin/wechat!refuseStore" //拒绝邀请url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/invite2.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

    </script>
    
	
  </head>
	<body style="background: #f0f0f0;" class="bg_p">
		<div style="padding: 16px;">
			<div class="caption caption_tpc" style="margin-top: 8px;">
				<img src="resources/images/caption_arrow.png" width="14" height="14"
					class="caption_arrow " />
				邀请人信息
			</div>
			<ul class="tj_strange">
				<li class="input_g">
					<img src="resources/images/icon1.png" class="input_icon" />
					<span style="position: relative"> 
					     <input  type="text" class="input1  input_s" value="<s:property value="#request.storeAgent.top.user.realName"/>" style="border-bottom: 0; width: 99.2%; border-left: 0px; border-right: 0px;" readonly="readonly"/>
					</span>
				</li>
				<li class="input_g">
					<img src="resources/images/icon2.png" alt="" class="input_icon" />
					<span style="position: relative"> 
					      <input  type="text" class="input1" value="<s:property value="#request.storeAgent.top.phoneDecimal"/>" style="width: 99.2%; border-left: 0px; border-right: 0px;" readonly="readonly"/>
					 </span>
				</li>
				<li class="input_g" style="padding-bottom: 20px;">
					<img src="resources/images/icon10.png" alt="" class="input_icon" />
					<div class="input_a">
						<div class="tips_gray">
							<font color="#666">邀请备注</font>
						</div>
					</div>
					<textarea rows="3" class="textarea1" readonly="readonly"><s:property value="#request.storeAgent.memo"/></textarea>
					<div class="clear"></div>
				</li>
				<div class="clear"></div>
			</ul>
			<div class="btn_w">
				<input type="button" class="btn_zc btn_zc_m" value="接受邀请" id="sub1"/>
				<input type="button" class="btn_zc_gray btn_zc_m" value="拒绝邀请" id="sub2" style="margin-top: 0 !important;" />
				<input type="hidden" id="storeId" value="<s:property value="#request.storeAgent.storeId"/>"/>
				<input type="hidden" id="agentId" value="<s:property value="#request.storeAgent.agentId"/>"/>
			</div>
		</div>
	</body>
</html>

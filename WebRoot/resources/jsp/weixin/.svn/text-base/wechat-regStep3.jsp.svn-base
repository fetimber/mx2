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
    <title>专业经纪人注册</title>
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
        	   registUrl : "weixin/wechat!speRegist",     //专业经纪人注册url
        	   agentUrl : "weixin/wechat!queryAgentUser", //经纪人校验
        	   speUrl : "weixin/wechat!checkSpeAgent",     //专业经纪人校验
               sucUrl :  ""                             //登录成功后跳转url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/regStep3.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body class="bg">


		<div class="part_2 form_div">
			<ul class="part_st">
				<li class="input_g">
					<img src="resources/images/icon1.png" alt="" class="input_icon_aa" />
					<div class="input_ab"><input  type="text" class="input_aa" id="realName" placeholder="真实姓名" /></div>
					<span class="must">*</span>
				</li>
				<li class="input_g" style="border-top:1px solid #eee;border-bottom:1px solid #eee;">
					<img src="resources/images/icon_11.png" alt="" class="input_icon_aa" />
					<div class="input_ab"><input  type="text" class="input_aa" id="idtNum" placeholder="身份证号码" /></div>
					<span class="must">*</span>
				</li>
				<li class="input_g">
					<img src="resources/images/icon7.png" alt="" class="input_icon_aa" />
					<div class="input_ab"><select  class="sel1_aa input1_mb" id="workArea">
						<option value="">
								请选择工作区域
					    </option>
				       <s:iterator value="#request.areas" var="area" status="st">
						<option value="<s:property value='#area.areaName'/>">
							<s:property value='#area.areaName' />
						</option>
					    </s:iterator>
						</select></div> <span class="must">*</span>
				</li>
				<li class="input_g" style="border-top:1px solid #eee;border-bottom:1px solid #eee;">
					<img src="resources/images/icon12.png" alt="" class="input_icon_aa" />
					<div class="input_ab"><input  type="text" class="input_aa" id="workSpace" placeholder="所属楼盘" /> </div>
					<span class="must">*</span> 
				</li>
				<li class="input_g">
					<img src="resources/images/icon2.png" alt="" class="input_icon_aa" />
					<div class="input_ab"><input  type="tel" class="input_aa" id="referee" placeholder="推荐人的手机号码（选填）" /></div>
				</li>
			</ul>
		</div>
		<div style="padding: 0 32px;margin-top:32px;" class="form_div">
			<input type="button" class="btn_zc" value="提交" id="sub1"/>
		</div>
		<div class="part_3" style="display: none;">
			<div class="tips_cont">
				<p>
					您填写的推荐人号码不符合推荐条件，
				</p>
				<p>
					是否继续完成注册提交？
				</p>
			</div>
			<input type="button" class="btn_zc" value="是。确认提交" id="sub2"/>
			<input type="button" class="btn_zc_gray" value="否。返回上一页" id="concel1" />
		</div>
	</body>
</html>

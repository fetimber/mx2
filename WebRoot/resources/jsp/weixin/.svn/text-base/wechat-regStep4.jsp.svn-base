<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册-步骤四</title>
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
               registUrl : "weixin/wechat!register",                //登录url
               openId :   "ojMT5txpoLl4VfLQm2xHC30jf-v0",//用户的openId
               sucUrl :  "",                            //登录成功后跳转url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/regStep4.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body>
		<div class="regis_step">
			<dl class="regis_step_a">
				<dd></dd>
				<dt>
					输入基本信息
				</dt>
			</dl>
			<div class="regis_step_bar"></div>
			<dl class="regis_step_a">
				<dd></dd>
				<dt>
					输入密码
				</dt>
			</dl>
			<div class="regis_step_bar"></div>
			<dl class="regis_step_a">
				<dd></dd>
				<dt>
					输入推荐码
				</dt>
			</dl>
			<div class="regis_step_bar"></div>
			<dl class="regis_step_a">
				<dd></dd>
				<dt>
					完善个人信息
				</dt>
			</dl>
			<div class="clear"></div>
		</div>
		<div class="part_1" style="margin-bottom: 0">
			<ul>
				<li>
					<img src="resources/images/icon_10.png" width="40" height="40" alt="" />
					<div class="input_a">
						<input id="bankAccount" name="bankAccount" type="text" class="input1" placeholder="请输入您的银行卡号" />
					</div>
					<div class="clear"></div>
				</li>
				<li style="padding-bottom: 20px;">
					<img src="resources/images/icon_11.png" width="40" height="40" alt="" />
					<div class="input_a" style="border-bottom: 1px solid #eee;">
						<p style="line-height: 60px;">
							个人名片
						</p>
						<p style="height: 134px;">
							<img src="resources/images/add_imgs.png"
								style="width: 102px; height: 102px; cursor: pointer;" />
						</p>
					</div>
					<div class="clear"></div>
				</li>
				<li style="padding-bottom: 20px;">
					<img src="resources/images/icon_11.png" width="40" height="40" alt="" />
					<div class="input_a" style="border-bottom: 1px solid #eee;">
						<p style="line-height: 60px;">
							身份证明信息
						</p>
						<p style="height: 134px;">
							<img src="resources/images/add_imgs.png"
								style="width: 102px; height: 102px; cursor: pointer;" />
						</p>
					</div>
					<div class="clear"></div>
				</li>
			</ul>
		</div>
		<div class="btn_w">
			<input type="button" class="btn_zc" value="完成注册" />
		</div>
	</body>
</html>

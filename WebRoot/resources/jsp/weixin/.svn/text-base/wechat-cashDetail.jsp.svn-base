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
		<title>我的账户</title>
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
        	   cplUrl : "weixin/wechat!complain",                //申诉url
               sucUrl :  "",                            //申诉成功后跳转url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/brokerage.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body class="bg">
		<div class="rec_h">
			<div class="rec_h_info" align="center">
				<img src="resources/images/img_head.png" width="100" height="100" />
			</div>
		</div>
		<div class="part_1" style="margin-bottom: 0">
			<dl class="m_2">
				<dd>
					可结佣金
				</dd>
				<dt class="m_txt1">
					<s:property value="#request.agentUser.account.usable" />
					<span class="yuan">元</span>
				</dt>
				<dt class="m_txt2">
					申请结佣
				</dt>
			</dl>
			<dl class="m_3">
				<dd>
					可提现佣金
				</dd>
				<dt class="m_txt1">
					<s:property value="#request.agentUser.account.cash" />
					<span class="yuan">元</span>
				</dt>
				<dt class="m_txt2">
					申请提现
				</dt>
			</dl>
			<div class="clear"></div>
			<ul class="rec_tab">
				<li class="rec_show">
					可结佣金
				</li>
				<li>
					可提现佣金
				</li>
				<div class="clear"></div>
			</ul>
			<ul class="rec_con">
				<li>
					<div style="padding: 0 20px;">
						<div class="caption1">
							<span class="cap_txt1">提现办理中：<font color="#c70013">1200元</font>
							</span><span class="cap_txt2">已提现总额：<font color="#c70013">3200元</font>
							</span>
							<div class="clear"></div>
						</div>
					</div>
					<div style="padding: 0 20px">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="tab_mlists">
							<tr>
								<td width="31%" align="center">
									2014年4月18日
								</td>
								<td width="40%" align="center">
									￥100.0
								</td>
								<td width="29%" align="center">
									<font color="#6bace2">提现成功</font>
								</td>
							</tr>
							<tr>
								<td align="center">
									2014年4月18日
								</td>
								<td align="center">
									￥100.0
								</td>
								<td align="center">
									<font color="#ff7419">等待审核</font>
								</td>
							</tr>
							<tr>
								<td align="center">
									2014年4月18日
								</td>
								<td align="center">
									￥100.0
								</td>
								<td align="center">
									<font color="#c70013">提现失败</font>
								</td>
							</tr>
						</table>
					</div>
				</li>
				<li style="display: none;"></li>
			</ul>
		</div>
	</body>
</html>

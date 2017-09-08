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
		<title>门店管理</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/reset.css?v=044" rel="stylesheet" />
        <link href="resources/weixin/css/common.css?v=044" rel="stylesheet" />
        <link href="resources/weixin/css/widget_menu.css?v=044" rel="stylesheet" />
        <link href="resources/weixin/css/wicons.css?v=044" rel="stylesheet" />
        <link href="resources/weixin/css/home.css?v=044" rel="stylesheet" />
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  APP ={
        	   storeMemberUrl : "weixin/wechat!myStoreMember",
               detailUrl :   "weixin/wechat!customPage2"                     
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/storeMember.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body class="bg">
		<ul id="glist2_ul">
			<li>
				<div class="xm_tpc xm_tpc_s part_mt" id="div_xm_tpc1">
					<span>有效客户</span><img src="resources/images/arrow1_w1_u1.png" width="16" height="16" class="arrow5" />
				</div>
				<div class="d_p" id="d_p1">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="tab_cust tab_b tab_p8" id="tab1" style="margin-bottom:0;">
						<tr>
							<th width="20%" align="left" valign="middle" style="padding-left:8px;">
								姓名
							</th>
							<th width="30%" align="center" valign="middle">
								电话
							</th>
							<th width="30%" align="center" valign="middle">
								注册时间
							</th>
							<th width="10%" align="center" valign="middle">
								数量
							</th>
							<th width="10%" align="center" valign="middle" style="padding-right:8px;">
								详情
							</th>
						</tr>
					</table>
				    <p class="more_1" id="more1"><a href="javascript:;">查看更多&nbsp;&nbsp; <img src="resources/images/arrow1.png" width="16" height="16" /></a></p>
				</div>
			</li>
		</ul>
	</body>
</html>

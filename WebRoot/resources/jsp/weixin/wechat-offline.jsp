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
		<title>检查记录</title>
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
        	   offlineUrl : "weixin/wechat!offline",
               detailUrl :   "weixin/wechat!detail_check",
               exitUrl: "weixin/wechat!exitStore",
               sucUrl :  ""          
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/offline.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
	</head>
	<body class="bg">
		<ul id="glist2_ul">
			<li>
				<div class="xm_tpc xm_tpc_s part_mt" id="div_xm_tpc1">
					<span>检查记录列表</span><img src="resources/images/arrow1_w1_u1.png" width="16" height="16" class="arrow5" />
				</div>
				<div class="d_p" id="d_p1">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="tab_cust tab_b tab_p8" id="tab1" style="margin-bottom:0;">
						<tr>
							<th width="20%" align="left" valign="middle" style="padding-left:8px;">
								房间号
							</th>
							<th width="30%" align="center" valign="middle">
								检查时间
							</th>
							<th width="25%" align="center" valign="middle">
							            得分
							</th>
							<th width="25%" align="center" valign="middle" >
								详情
							</th>
						</tr>
					</table>
						<p class="more_1" id="more1"><a href="javascript:;"  >查看更多&nbsp;&nbsp; <img src="resources/images/arrow1.png" width="16" height="16" /></a></p>
				</div>
			</li>
		</ul>
		<div class="part_3">
		   <input type="button" class="btn_zc" value="&lt; 返回当前宿舍楼 " id="tj_more"/>
		   <input type="button" class="btn_zc_gray" value="返回宿舍楼列表&gt;" id="sub1"/>
		</div>
		
	</body>
</html>

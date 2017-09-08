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
		<title>客户管理</title>
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
        	   myCustomUrl : "weixin/wechat!myCustom",
        	   myMissCustomUrl : "weixin/wechat!myMissCustom",
               detailUrl :   "weixin/wechat!customDetail",
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/custom.js?v=044");
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
							<th width="22%" align="left" valign="middle" style="padding-left:8px;">
								客户姓名
							</th>
							<th width="38%" align="center" valign="middle">
								最新跟进时间
							</th>
							<th width="20%" align="center" valign="middle">
								状态
							</th>
							<th width="20%" align="center" valign="middle" style="padding-right:8px;">
								详情
							</th>
						</tr>
					</table>
						<p class="more_1" id="more1"><a href="javascript:;"  >查看更多&nbsp;&nbsp; <img src="resources/images/arrow1.png" width="16" height="16" /></a></p>
				</div>
				<div class="xm_tpc xm_tpc_ls part_mt" id="div_xm_tpc2">
					<span>流失客户</span><img src="resources/images/arrow1_w1.png" width="16" height="16" class="arrow5" />
				</div>
				<div class="d_p" id="d_p2" style="display: none;">
				     <table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="tab_cust" id="tab2">
						<tr>
							<th width="22%" align="left" valign="middle" style="padding-left:8px;">
								客户姓名
							</th>
							<th width="38%" align="center" valign="middle">
								最新跟进时间
							</th>
							<th width="20%" align="center" valign="middle">
								状态
							</th>
							<th width="20%" align="center" valign="middle" style="padding-right:8px;">
								详情
							</th>
						</tr>
					</table>
					<p class="more_1" id="more2"><a href="javascript:;"  >查看更多&nbsp;&nbsp; <img src="resources/images/arrow1.png" width="16" height="16" /></a></p>
				</div>
				<div>
					<div class="part_1" style="margin-top: 16px;">
					 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cust_lists cust_lists_t cust_lists_t1 cust_lists_tab" style="padding:0;">
           <tr>
              <td rowspan="2"  colspan="2" valign="middle">推荐客户统计</td>
            </tr>
          </table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cust_lists cust_lists_t cust_lists_tab">
							<tr>
								<td valign="middle">
									当月推荐
								</td>
								<td align="right" valign="middle" style="padding-right:16px;">
									<s:property value="#request.customerInfo.monthRef"/>
								</td>
							</tr>
							<tr>
								<td valign="middle">
									当月到访
								</td>
								<td align="right" valign="middle" style="padding-right:16px;">
									<s:property value="#request.customerInfo.monthRiv"/>
								</td>
							</tr>
							<tr>
								<td valign="middle">
									当月认购
								</td>
								<td align="right" valign="middle" style="padding-right:16px;">
									<s:property value="#request.customerInfo.monthSig"/>
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="cust_lists cust_lists_t cust_lists_tab" style="border-bottom: 0";>
							<tr>
								<td valign="middle">
									累计推荐
								</td>
								<td align="right" valign="middle" style="padding-right:16px;">
									<font color="red"><s:property value="#request.customerInfo.refTotal"/></font>
								</td>
							</tr>
							<tr>
								<td valign="middle">
									累计签约
								</td>
								<td align="right" valign="middle" style="padding-right:16px;">
									<font color="red"><s:property value="#request.customerInfo.refSig"/></font>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</li>
			<li>



			</li>
		</ul>
	</body>
</html>

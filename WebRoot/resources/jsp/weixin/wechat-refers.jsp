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
    <title>推荐经纪人列表</title>
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
        	   commitUrl : "weixin/wechat!applyReferReward"
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/refers.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body class="background:#f0f0f0;">
	<div style="padding-top:20px;">
		<div class="caption caption_tpca">
			<p>
				推荐经纪人注册
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="tab_cust">
				<tr>
					<th width="22%" align="left" valign="middle" style="padding-left:8px;">
						姓名
					</th>
					<th width="29%" align="left" valign="middle">
						电话
					</th>
					<th width="24%" align="left" valign="middle">
						审核状态
					</th>
					<th width="25%" align="left" valign="middle" style="padding-left:8px;">
						备注
					</th>
				</tr>
				<s:iterator value="#request.myRefers" var="refer" status="st">
				  <tr class="data_tr">
					<td align="left" valign="middle" style="padding-left:8px;">
						<s:property value="#refer.user.realName"/>
					</td>
					<td align="left" valign="middle">
						<s:property value="#refer.user.phone"/>
					</td>
					<td align="left" valign="middle">
						审核通过
					</td>
					<td align="left" valign="middle" style="padding-right:8px;">&nbsp;</td>
				</tr>
				</s:iterator>
			</table>
			<s:if test="#request.myRefers == null || #request.myRefers.size() == 0 || #request.regCount == 0">
			     <div class="btn_w">
					<input class="btn_zc_gray" type="button" value="申请推荐奖" disabled="disabled">
				 </div>
			</s:if>
			<s:else>
			    <div class="btn_w">
					<input type="button" class="btn_zc" value="申请推荐奖" />
				</div>
			</s:else>
				
				
			</div>
	</div>
	</body>
</html>

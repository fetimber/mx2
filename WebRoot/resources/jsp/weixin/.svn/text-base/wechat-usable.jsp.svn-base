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
        	   opUrl : "weixin/wechat!usableApply"
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/usable.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body class="bg">
		<div class="rec_h">
			<div class="kjm_h" align="center">
				可结佣金：30,000元
			</div>
		</div>
		<div class="caption">
			签约佣金：
			<font color="#c70013">20,000元</font>
		</div>
		<div class="part_1 kjm_lists">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr> 
			    <td>客户</td>
			    <td>套数</td>
			    <td>佣金金额</td>
			</tr>
				<s:iterator value="page.beans" var="item" status="status">
					<tr class="cus_tr" data-cid="<s:property value="#item.id"/>">
						<td width="30%">
							<s:property value="#item.customerName"/>
						</td>
						<td width="35%">
							<s:property value="#item.houseCount"/>
						</td>
						<td width="35%">
							<s:property value="#item.housePrice*#item.houseCount"/>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<!--  
		<div class="caption">
			推荐奖励：
			<font color="#c70013">8,000元</font>
		</div>
		<div class="part_1 kjm_lists">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="38%">
						客户A项目
					</td>
					<td>
						佣金金额
					</td>
				</tr>
				<tr>
					<td>
						客户A项目
					</td>
					<td>
						佣金金额
					</td>
				</tr>
			</table>
		</div>
		<div class="caption">
			到访奖励：
			<font color="#c70013">2,000元</font>
		</div>
		<div class="part_1 kjm_lists">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="38%">
						客户A项目
					</td>
					<td>
						到访奖励
					</td>
				</tr>
				<tr>
					<td>
						客户A项目
					</td>
					<td>
						到访奖励
					</td>
				</tr>
			</table>
		</div>
		-->
		<div class="btn_w">
			<input type="button" value="一键申请结佣" class="btn_zc" />
		</div>
	</body>
</html>

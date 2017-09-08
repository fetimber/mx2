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
		<title>客户信息</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8"
			http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  APP ={
        	   cbUrl : "weixin/wechat!custPress",           
               detailUrl :   "weixin/wechat!customDetail",
               sucUrl :  "",                         
               apply1 : "weixin/wechat!apply1",
               apply2 : "weixin/wechat!apply2",
               apply3 : "weixin/wechat!apply3",
               readUrl : "weixin/wechat!readRecord"
         }
    </script>
		<script>

        (function(l){
            seajs.config({
                base:"<%=basePath%>/resources/weixin",
                map:[
                    [".js", (l&&l[1]||"")+".js?v=045"]
                ]
            });
            //
            seajs.use("<%=basePath%>resources/weixin/js_cmd/customDetail2.js");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body class="bg">
		<div class="part_1" style="padding:8px 16px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="custinfo_lists" style="border-bottom: 0;">
				<tr>
					<td  align="left">
						姓名：<s:property value="#request.customer.customerName" />
					</td>
				</tr>
				<tr align="left">
					<td height="26" >
						手机号码：<s:property value="#request.customer.customerDecimal" />
					</td>
				</tr>
				<tr align="left">
					<td height="26">
						推荐时间：<s:date name="%{#request.customer.referTime}" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td height="26">
						推荐楼盘：<s:property value="#request.customer.houseInfo.projectName" />
					</td>
				</tr>
			</table>

		</div>
		<div class="part_1" style="padding:0px 16px 16px;">
			<div class="timebar_l">
				当前状态
			</div>
			
			
			<div class="timebar_r">
			   <s:if test="#request.customer.customerStatus == 1 || #request.customer.customerStatus == 2">
			     <dl class="step_a_now_arrow">
			        <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   <s:if test="#request.customer.customerStatus == 3">
			     <dl class="step_a_now">
			        <dd class="timebar_p"></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now_arrow">
				    <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   <s:if test="#request.customer.customerStatus == 4">
			     <dl class="step_a_now">
			        <dd class="timebar_p"></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now_arrow">
				    <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   <s:if test="#request.customer.customerStatus == 5">
			     <dl class="step_a_now">
			        <dd class="timebar_p"></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now_arrow">
				    <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   <s:if test="#request.customer.customerStatus == 6">
			     <dl class="step_a_now">
			        <dd class="timebar_p"></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now_arrow">
				    <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl>
				    <dd class="timebar_p"></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   <s:if test="#request.customer.customerStatus == 7 || #request.customer.customerStatus == 8">
			     <dl class="step_a_now">
			        <dd class="timebar_p"></dd>
					<dd>
						新客户
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						电联
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						到访
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						认购
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now">
				    <dd class="timebar_p"></dd>
					<dd>
						签约
					</dd>
					<dt></dt>
				</dl>
				<dl class="step_a_now_arrow">
				    <dd class="timebar_p"><img src="resources/images/arrow3.png" width="20" height="20" /></dd>
					<dd>
						结佣
					</dd>
					<dt></dt>
				</dl>
			   </s:if>
			   
			   
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
			<div class="part_1" style="padding:16px 0 16px 16px;">
			<div  class="timebar_tpc">进度跟踪</div>
			   <s:iterator value="#request.customer.records" var="record" status="st">
					<s:if test="#st.index == 0">
						<div style="margin-bottom: 16px;">
							<div class="clear"></div>
							<div class="step1">
								<s:if test="#record.messageType == 0">
							         <img src="resources/images/time1.png" width="20" height="20" class="img_read"/>
							    </s:if>
							    <s:else>
							         <img src="resources/images/time1_1.png" width="20" height="20" class="img_read"/>
							    </s:else>
								<div class="step_a_r">
									<s:date name="%{#record.operateTime}"
										format="yyyy-MM-dd HH:mm:ss" />
								</div>
								<div class="clear"></div>
								<div id="firstDiv" class="khx_tpc1 _title" data-read="<s:property value="#record.messageType" />" data-rId="<s:property value="#record.id" />" >
									<s:if test="#record.operateType == 0">
									             申诉
									</s:if>
									<s:if test="#record.operateType == 1">
									             未分配
									</s:if>
									<s:if test="#record.operateType == 2">
									            已分配 未处理
									</s:if>
									<s:if test="#record.operateType == 3">
									           电联
									</s:if>
									<s:if test="#record.operateType == 4">
									           到访
									</s:if>
									<s:if test="#record.operateType == 5">
									          认购
									</s:if>
									<s:if test="#record.operateType == 6">
									          签约
									</s:if>
									<s:if test="#record.operateType == 7">
									         申请结佣
									</s:if>
									<s:if test="#record.operateType == 8">
									          已结佣
									</s:if>
									<s:if test="#record.operateType == 9">
									          申请提现
									</s:if>
									<s:if test="#record.operateType == 10">
									          催办
									</s:if>
									<img src="resources/images/arrow1_w1.png"  width="16" height="16"  class="arrow_p _img"  style="margin-right:16px;"/>
								</div>
								<div class="khx_txt1 _content" style="display: none;">
									<s:property value="#record.operateContent" />
								</div>
							</div>

						</div>
					</s:if>
					<s:else>
			          <div style="margin-bottom: 16px;">
							<div class="clear"></div>
							<div class="step1">
							    <s:if test="#record.messageType == 0">
							         <img src="resources/images/time1.png" width="20" height="20" class="img_read"/>
							    </s:if>
							    <s:else>
							         <img src="resources/images/time1_1.png" width="20" height="20" class="img_read"/>
							    </s:else>
								
								<div class="step_a_r">
									<s:date name="%{#record.operateTime}"
										format="yyyy-MM-dd HH:mm:ss" />
								</div>
								<div class="clear"></div>
								<div class="khx_tpc1 _title" data-read="<s:property value="#record.messageType" />" data-rId="<s:property value="#record.id" />">
									<s:if test="#record.operateType == 0">
									             申诉
									</s:if>
									<s:if test="#record.operateType == 1">
									             未分配
									</s:if>
									<s:if test="#record.operateType == 2">
									            已分配 未处理
									</s:if>
									<s:if test="#record.operateType == 3">
									           电联
									</s:if>
									<s:if test="#record.operateType == 4">
									           到访
									</s:if>
									<s:if test="#record.operateType == 5">
									          认购
									</s:if>
									<s:if test="#record.operateType == 6">
									          签约
									</s:if>
									<s:if test="#record.operateType == 7">
									         申请结佣
									</s:if>
									<s:if test="#record.operateType == 8">
									          已结佣
									</s:if>
									<s:if test="#record.operateType == 9">
									          申请提现
									</s:if>
									<s:if test="#record.operateType == 10">
									          催办
									</s:if>
									<img src="resources/images/arrow1_w1.png"  width="16" height="16"  class="arrow_p" style="margin-right:16px;"/>
								</div>
								<div class="khx_txt1 _content" style="display: none;">
									<s:property value="#record.operateContent" />
								</div>
							</div>

						</div>
			       </s:else>
				

			</s:iterator>
				
				<input type="hidden" id="cid" value="<s:property value="#request.customer.id" />"/>
			</div>
		</div>



	</body>
</html>

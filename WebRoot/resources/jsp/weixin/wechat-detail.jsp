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
    <title>楼盘详情</title>
	<meta charset="utf-8">
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
    <meta content="telephone=no, address=no" name="format-detection">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
    <link href="resources/weixin/css/reset.css?v=044" rel="stylesheet" />
    <link href="resources/weixin/css/common.css?v=044" rel="stylesheet" />
    <link href="resources/weixin/css/detail3.css?v=044" rel="stylesheet" />
	<link href="resources/weixin/css/style.css?v=045" rel="stylesheet" />
	
	<script src="resources/weixin/lib_cmd/sea.js?v=044"></script>
    <script>
        (function (l) {
            seajs.config({
                base: "<%=basePath%>/resources/weixin",
                map: [
                    [".js", (l && l[1] || "") + ".js?v=044"]
                ]
            });
            seajs.use("js_cmd/weiDetail");
        })(location.href.match(/de(\-\d+)bug/));
    
    </script>
  </head>
	<body class="bg">
		<header data-role="header">
		<div data-role="widget" data-widget="slider_3" class="slider_3">
			<section data-role="widget" data-widget="img_prev_view"
				class="widget_wrap">
			<div id="slider_3_wrap" class="slider_3_wrap">
				<ul>
				    <s:iterator value="#request.imgs" var="img" status="st1">        
				         <s:if test="#st1.index == 0">
				           <li class="swiper-slide">
						    <a href="javascript:;"> <img width="200px" height="200px" src="<s:property value="#img.filePath" />" data-src="<s:property value="#img.filePath" />" /> </a>
					       </li>
					     </s:if>
				    </s:iterator>

				</ul>
				<div id="slider_3_indicate" class="slider_3_indicate">
					<!---->
				</div>
			</div>
			</section>
		</div>
		</header>

		<div class="detail_part1">
			<p class="detail_h">
				<s:property value="#request.project.projectSummary" />
			</p>
			<div  class="detail_txt3"><span class="tpc_w"> 均价：</span><span class="p_o"><s:property value="#request.project.price" />元/平方米</span></div>
            <div  class="detail_txt3"><span class="tpc_w">面积范围：</span><span class="p_o"><s:property value="#request.project.downArea" />-<s:property value="#request.project.upArea" />平方米</span></div>
            <div  class="detail_txt3"><span class="tpc_w">佣金：</span><span class="p_o"><s:property value="#request.project.brokerage" />元/套</span></div>
		</div>
		<div class="detial_btn">
			<input  type="button" class="btn_cb" style="width: 98%;" id="tjkh" value="推荐客户" />
<%--			<input  type="button" class="btn_ss" id="wdkh" value="我的客户" />--%>
			<div class="clear"></div>
		</div>
		
		<s:iterator value="#request.configs" var="item" status="st">

			<div class="detail_part">
				<p class="detail_h1">
				     <span><s:property value="#item.configName" /></span>
<%--				     <img src="resources/images/arrow1.png" class="m_arrow" />--%>
				     <div class="clear"></div>	
				</p>
				<div style="display: none;" class="house_dl">
					<div>
						<p class="detai_subh">
							【
							<s:property value="#item.configTitle" escapeHtml="false"/>
							】
						</p>
						<p class="detail_txt2">
							<s:property value="#item.configContent" escapeHtml="false"/>
						</p>
						<s:iterator value="#item.files" var="file" status="st2">
							<p class="detail_img1">
								<img src="<s:property value="#file.filePath" />" />
							</p>
						</s:iterator>
					</div>
				</div>
			</div>
		</s:iterator>
<%--		<div class="btn_w" style="margin-bottom: 15px;">--%>
<%--			<input type="button" class="btn_zc" id="bbkh" value="报备客户" />--%>
<%--		</div>--%>
<%--		<div>&nbsp;&nbsp;</div>--%>
		<div class="clear"></div>
        <input type="hidden" id="houseId" value="<s:property value="#request.project.id" />"/>
        <input type="hidden" id="area" value="<s:property value="#request.project.area" />"/>



	</body>
</html>

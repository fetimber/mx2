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
		<title>操作结果</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script type="text/javascript">
		var APP = {
				hid : "<s:property value='#request.hid'/>" || "",    //楼盘ID
				area : "<s:property value='#request.area'/>" || ""  //所属区域

		};
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/opeResult.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
	</head>
	<body class="bg">
<%--		<div class="su_img1">--%>
<%--			<img src="resources/images/su_img1.png" width="79" height="67" />--%>
<%--		</div>--%>
<%--		<div class="su_txt">--%>
<%--			恭喜您，推荐成功！--%>
<%--		</div>--%>
<%--		<div class="btn_w">--%>
<%--			<a href="javascript:;" class="btn_tjgd" style="text-align: center;" id="tj_more"><img src="resources/images/icon_more.png"/>推荐更多客户&gt;&gt;</a>--%>
<%--		</div>--%>
<%--		<div class="btn_w">--%>
<%--			<input type="button" class="btn_zc" value="查看客户列表" onclick="back('<s:property value="#request.backUrl"/>');"/>--%>
<%--		</div>--%>
		<div class="part_3">
			<div class="tips_cont">
				<p class="su_img1">
					<img src="resources/images/su_img1.png" width="79" height="67" />
				</p>
				<p class="su_txt">
					您已检查成功 
					房间号 :<s:property value='#request.roomCode'/> 得分：<s:property value='#request.totals'/>
				</p>
			</div>
			<input type="button" class="btn_zc" value="< 返回当前宿舍楼" id="tj_more" style="margin-top:0!important;"/>
			<input type="button" class="btn_zc_gray" value="返回宿舍楼列表 >" id="sub1"/>
		
		</div>
	</body>
</html>

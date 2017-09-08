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
		<title>申诉</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8"
			http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
			name="viewport">
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/complain.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body class="bg">
<%--		<div class="part_1">--%>
<%--			<textarea id="cpMsg" cols="" rows="10" class="texta" placeholder="请输入申诉内容"></textarea>--%>
<%--		</div>--%>
<%--		<div class="btn_w">--%>
<%--			<input  type="button" value="提交申诉" class="btn_zc" />--%>
<%--		</div>--%>
		<div class="part_3">
			<div class="tips_cont1">
				<p class="tj_ssxx">
					请填写申诉信息
				</p>
				<p>
					<textarea cols="" rows="6" class="tj_area" placeholder="请输入申诉内容" id="cpMsg"></textarea>
				</p>
			</div>
			<input type="button" class="btn_zc" value="确认提交，返回上一页" />
		</div>
		<input type="hidden" id="cid" value="<s:property value="#request.cId" />"/>
	</body>
</html>

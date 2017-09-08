<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<s:include value="../common/meta.jsp" />
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
		<style type="text/css">
			.imgs{margin:2px;border:2px solid #FFF}
		</style>
		<script type="text/javascript">
			var api = frameElement.api, W = api.opener;
			$(function(){
				api.button({
				    name: '确定',
				    focus: true,
				    disabled:true,
				    callback: function(){
				    	
				    }
				},{
				    name: '取消'
				},{
					name:'查看大图',
					disabled:true,
					callback:function(){
						window.open(whi_path);
						return false;
					}
				});
			});
			function autosize(item){
				AutoResizeImage(400,300,item);
			}
			var selected;
			function select_this(item){
				api.button({
				    name: '确定',
				    focus: true,
				    disabled:false,
				    callback: function(){
				    	W.set_pic($(selected).attr("img-id"),$(selected).attr("src"));
				    }
				},{
				    name: '取消'
				},{
					name:'查看大图',
					disabled:false,
					callback:function(){
						window.open(selected.src);
						return false;
					}
				});
				selected = item;
				$(".imgs").css("border","2px solid #FFF");
				$(item).css("border","2px solid red")
			}
		</script>
	</head>
	<body>
		<s:iterator value="#request.pictures" var="item" status="st">
			<img src="<s:property value="#item.filePath" />" onload="autosize(this)" onclick="select_this(this)" class="imgs" img-id="<s:property value="#item.id" />" />
		</s:iterator>
	</body>
</html>

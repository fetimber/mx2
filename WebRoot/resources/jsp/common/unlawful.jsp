<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cc" uri="/config"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>洽银金融-房小帅-投资理财</title>
<s:include value="../common/meta.jsp" />
</head>
<body>
	<s:action name="user!loan_header" namespace="/system"
		executeResult="true" />
	<s:include value="../common/product_menu.jsp?select=0" />
	<div class="jk_main tips_main">
		<p class="tips_txt01">您提交的数据异常，请重新编辑后再次提交。</p>
		<p class="tips_img1">
			<img src="resources/images/img_szyc.png" width="204" height="439" />
		</p>
	</div>
	<s:include value="../common/loan_bottom.jsp"></s:include>
</body>
</html>


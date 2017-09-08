<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <s:include value="../common/meta.jsp" />
  <style type="text/css">
  	.input_1 {font-family:"Courier New","微软雅黑"}
  </style>
  <script type="text/javascript">
  $(function(){
	  $('#base_frm').validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 10, +5',maxErrorsPerField: true,
			autoHideDelay:3000
		})
  });
  </script>
</head>
  <body>
  <div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />微信设置&nbsp;>&nbsp;微信基础设置</div>
<s:form action="config!setting_base_save" namespace="/admin" method="post" id="base_frm">
	<table width="60%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;">
  <tr>
    <td width="16%" align="right">URL</td>
    <td width="84%">
    	<s:textfield name="config.url" cssClass="input_1 input_1_w validate[custom[url],maxSize[100]]"></s:textfield>
    </td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td valign="top" style="padding-top:0;"> <span class="f_gray">必须以http：//开头，目前支持80端口</span></td>
  </tr>
  <tr>
    <td align="right">Token</td>
    <td>
    	<s:textfield name="config.token" cssClass="input_1 input_1_w validate[required,maxSize[20]]"></s:textfield>
    </td>
  </tr>
  <tr>
    <td align="right">EncodingAESKey</td>
    <td>
    	<s:textfield name="config.encodingAESKey" cssClass="input_1 input_1_w validate[minSize[43],maxSize[43],custom[onlyLetterNumber]]"></s:textfield>
    </td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td valign="top" style="padding-top:0;"> <span class="f_gray">消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9</span></td>
  </tr>
  <tr>
    <td align="right">AppID</td>
    <td>
    <s:textfield name="config.appid" cssClass="input_1 input_1_w validate[required,maxSize[100],custom[onlyLetterNumber]]"></s:textfield>
    </td>
  </tr>
  <tr>
    <td align="right">AppSecret</td>
    <td height="50">
    <s:textfield name="config.appSecret" cssClass="input_1 input_1_w validate[required,maxSize[100],custom[onlyLetterNumber]]"></s:textfield>
    </td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td height="60"><input type="submit" name="button" id="button" value="提交"  class="btn_tj btn_tj_w"/></td>
  </tr>
</table>
</s:form>
  </body>
</html>
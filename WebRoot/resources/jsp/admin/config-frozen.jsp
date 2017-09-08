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
  <script type="text/javascript">
  
    $(function(){
        	$("#configview").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
         });
   
         $("input[name='input2']").bind("click",function(){  
                 var frozenPer =  $('#frozenPer').val();
                 var frozenOrd =  $('#frozenOrd').val();
                 if(!$("#configview").validationEngine('validate')){
                    $.dialog.tips('数据格式不正确,只能填写数字',3,'alert.gif');
                    return false;  
                 }
                 
                 else if(frozenPer <  frozenOrd){
                    $.dialog.tips('专业经纪人需小于普通经纪人冻结时长',3,'alert.gif');
                    return false;
                 }
                 
                 else{
                    change("请确认是否需要保存"  , frozenPer , frozenOrd);
                 } 
 
	      });   
    });
    
    
      function change(tips,frozenPer,frozenOrd){
         var postParams = "frozenPer=" + frozenPer + "&frozenOrd=" + frozenOrd ;
            
	     $.dialog.confirm(tips, function(){
				$.post('admin/config!editfrozen', postParams ,function(data){
				    eval("data=" + data);
					if(data.result){
					    $.dialog.tips('保存成功',2,'success.gif',function(){
					    	window.location.reload(true);
					    });
					} else {
						$.dialog.tips('更新失败',3,'error.gif');
					}
				});
		 }, function(){
			 $.dialog.tips('已取消操作',3,'alert.gif');
		 });	 
	}	 
    
  </script>
  
</head>

<body style="background:#fdeeba; position:relative">
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />冻结时间管理(小时)</div>
<div class="m_main_t">
   <s:form action="config!frozen" namespace="/admin" method="POST" id="configview">
    <table width="70%" border="0" cellspacing="0" cellpadding="0" class="tab_1 tab_m_1">
     <tr>
      <td align="right" height="40">专业经纪：</td>
      <td><s:textfield  name="frozenPer" id="frozenPer" cssClass="input_1 input_t_w validate[required,custom[number],min[0],max[999999]"  /> </td>
    </tr>
    
    <tr>
      <td align="right" height="40">普通经纪：</td>
      <td><s:textfield  name="frozenOrd" id="frozenOrd" cssClass="input_1 input_t_w validate[required,custom[number],min[0],max[999999]]"  /> </td>
    </tr>
    
    <tr>
      <td height="40">&nbsp;</td>
      <td><input name="input2" type="button" value="保存" class="btn_tj btn_w1" style="width:170px;"/></td>
    </tr>
  </table>
  </s:form>
</div>
</body>
</html>

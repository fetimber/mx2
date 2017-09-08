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
               if($('input[name="radio"]:checked').val() == "1"){
                   
                   if(!$("#configview").validationEngine('validate')){
                    $.dialog.tips('数据格式不正确,只能填写数字',3,'alert.gif');
                    return false;  
                  }
                   
                   var redMax =  parseInt($('#redmax').val());
                   var redMin =  parseInt($('#redmin').val());
                   
                   if(redMax < redMin){
                      $.dialog.tips('红包最大金额必须大于最小金额',3,'alert.gif');
                      return false;
                   }else{
                      change("请确认是否需要保存" , "1" , redMax , redMin);
                   }
               }else{
                     //$.dialog.tips('红包金额仅在开启时可设置',3,'alert.gif');
                    change("请确认是否需要保存" , "0" , 0 , 0);   
               }  
               
	      });   
    });
    
    
      function change(tips,openRed,redMax,redMin){
         var postParams = "openRed=" + openRed + "&redMax=" + redMax + "&redMin=" + redMin;
            
	     $.dialog.confirm(tips, function(){
				$.post('admin/config!editred', postParams ,function(data){
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
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />红包管理</div>
<div class="m_main">
   <s:form action="config!red" namespace="/admin" method="POST" id="configview">
   <s:hidden name="openRed" id="openred" />
   <table width="70%" border="0" cellspacing="0" cellpadding="0" class="tab_1 tab_m">
    <tr>
      <td align="right">开启：</td>
      <td>  
	        <input name="radio" type="radio" id="radio" value="1" 
	        <s:if test="openRed == 1"> checked="checked" </s:if> style="vertical-align:middle;"/>
	        &nbsp;&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
	        <input name="radio" type="radio" id="radio" value="0" 
	        <s:if test="openRed == 0"> checked="checked" </s:if> style="vertical-align:middle;"/>
	        &nbsp;&nbsp;否
     </td>
    </tr>
     <tr>
      <td align="right">最大金额：</td>
      <td><s:textfield  name="redMax" id="redmax" cssClass="input_1 input_2_w validate[required,custom[number],min[0],max[999999]"  /></td>
    </tr>
    
    <tr>
      <td align="right">最小金额：</td>
      <td><s:textfield  name="redMin" id="redmin" cssClass="input_1 input_2_w validate[required,custom[number],min[0],max[999999]]"  />	</td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td><input name="input2" type="button" value="保存" class="btn_tj btn_w1" style="width:170px;"/></td>
    </tr>
  </table>
  </s:form>
</div>
</body>
</html>

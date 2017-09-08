<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
$(function(){
  $(".select02").selectmenu();
  
  $('#periods_calor').selectmenu({
			change:function(){
				periods(this.value);
			}
   });
  
  //绑定表单验证和提交事件
	$("#calor_form").validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +5', maxErrorsPerField: true,
					autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
   });		
  
 
  
  $("#buttoncalor").click(function() {  
    if($("#calcor_form").validationEngine('validate')){   
          //还款方式
          var profitmode = $("#profitmode_calor").val();
          //当前选择还款期数
          var periods = $("#periods_calor").val();
          $.get("loan/fillinfo!showrate",{profitmode:profitmode,periods:periods},function(data){
                     if("" != data.rate){
                        calculateRate(data.rate);
                     }			
	     }); 
	 }                
  });
  
  //初始化提示      
   periods($('#periods_calor').val());
 
});	

 function periods(objvalue){
       if(objvalue == '1'){
			$('#profitmode_calor').find("option[value=1]").remove().end().selectmenu( "refresh" );
			$('#profitmode_calor').find("option[value=3]").remove().end().selectmenu( "refresh" );
		} else {
			if($('#profitmode_calor').find("option[value=1]").length == 0
			&& $('#profitmode_calor').find("option[value=3]").length == 0){
				var option = $("<option value='1'>等额本息</option><option value='3'>每月还息到期还本</option>");
				$('#profitmode_calor').append(option).selectmenu( "refresh" );
			}
		}
  }  
  
//调用利率计算器
function calculateRate(rate){
  //还款方式
  var profitmode = $("#profitmode_calor").val();
  //当前选择还款期数
  var periods = $("#periods_calor").val();
  //利率
  //总金额
  var amount = $("#amount_calor").val();
    
  $.get("common!calculaterate",{profitmode:profitmode,periods:periods,rate:rate,amount:amount},function(data){
			$("#totalamount").html(changeTwoDecimal(data.total) + " 元");	
			$("#monthamount").html(changeTwoDecimal(data.interest) + " 元");		
  });

 }
 
 //保留两位小数
 function changeTwoDecimal(x) {  
	var f_x = parseFloat(x);  
	if (isNaN(f_x))  
	{  
	  return false;  
	}  
	var f_x = Math.round(x*100)/100;    
	return f_x;  
}  
</script>

<div class="jk_right_p1 jk_right_p1_btm">
					<p class="jk_right_topic1">
						<img src="resources/images/icon_jkjsq.png" width="26" height="26" />
						&nbsp;&nbsp;借款计算器
					</p>
					<s:form  namespace="/loan" method="post" id="calcor_form" >
					<table width="270" border="0" align="center" cellpadding="0"
						cellspacing="0" class="tab02">
						<tr>
							<td width="85" height="42">
								借款金额：
							</td>
							<td width="185" height="42">
								<label for="textfield7"></label>
								<input type="text"  id="amount_calor"
									class="input02 validate[required,custom[integer],min[1],max[300000]]" />
								元
							</td>
						</tr>
						<tr>
							<td width="85" height="42">
								借款期数：
							</td>
							<td width="185" height="42">
							    <label for="select"></label>
							    <s:select id="periods_calor"  list="configs.loan_period" listKey="configKey" listValue="configName" cssClass="select02 validate[required]" />
							</td>
						</tr>
						<tr>
							<td width="85" height="42">
								还款方式：
							</td>
							<td width="185" height="42">
								 <label for="select"></label>
							     <s:select id="profitmode_calor"  list="configs.profitmode" listKey="configKey" listValue="configName" cssClass="select02 validate[required]" />
							</td>
						</tr>

						<tr>
							<td width="85" height="42">
								&nbsp;
							</td>
							<td width="185" height="42">
								<input type="button" name="button" id="buttoncalor" value="开始计算"
									class="btn_js" />
							</td>
						</tr>
					</table>
					</s:form>
					<p class="jsjg_tpc">
						计算结果
						<font color="#999">（仅供参考）</font>
					</p>
					<p class="jsjg_txt">
						还款总金额：
						<font color="#ff671c" id="totalamount">0.00 元</font>
					</p>
					<p class="jsjg_txt">
						还款总利息：
						<font color="#ff671c" id="monthamount">0.00 元</font>
					</p>
				</div>

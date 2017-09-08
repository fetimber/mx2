<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
$(function(){
  $(".select02").selectmenu();

  $('#periods_calor').selectmenu({
			change:function(){
				periods(this.value);
			}
   });
  
   //绑定表单验证和提交事件
   $(".calc_frm").each(function(){
   	$(this).validationEngine({
		addPromptClass: 'formError-white formError-small',scroll:false,
		promptPosition: 'centerRight: 10, +5',maxErrorsPerField: true,
		autoHideDelay:3000,focusFirstField:false,autoHidePrompt:true
	});
   });
});	
</script>


<div class="jk_right">
	<div class="jk_right_p1">
		<p class="jk_right_topic1">
			<img src="resources/images/icon_dollarjl.png" width="26" height="26" />&nbsp;投资条件
		</p>
		<ul>
			<li>
				<img src="resources/images/icon_list.png" width="6" height="6" />
				&nbsp;&nbsp;
				具有中国国籍（不含港澳台居民）
			</li>
			<li>
				<img src="resources/images/icon_list.png" width="6" height="6" />
				&nbsp;&nbsp;
				<span style="font-family:Courier New;">21～55</span>周岁
			</li>
			<li>
				<img src="resources/images/icon_list.png" width="6" height="6" />
				&nbsp;&nbsp;
				税后收入<span style="font-family:Courier New;">3000</span>元以上
			</li>
		</ul>
	</div>
	<div class="jk_right_p1 jk_right_p1_btm">
		<p class="jk_right_topic1">
			<img src="resources/images/icon_question.png" width="26" height="26" />&nbsp;投资计算器
		</p>
		<s:form action="!calc" namespace="/product" method="get" cssClass="calc_frm" target="_brank">
			<table width="270" border="0" align="center" cellpadding="0"
				cellspacing="0" class="tab02">
				<tr>
					<td width="85" height="42">
						投资金额：
					</td>
					<td width="185" height="42">
						<s:textfield id="amount" name="calculator.amount" cssClass="input02 validate[required,custom[integer],min[1],max[100000000]]" />&nbsp;元
					</td>
				</tr>
				<tr>
					<td width="85" height="42">
						收益周期：
					</td>
					<td width="185" height="42">
						<s:textfield id="month" name="calculator.month" cssClass="input02 validate[required,custom[integer],min[1],max[36]]" />&nbsp;月&nbsp; 1至36的整数
					</td>
				</tr>
				<tr>
					<td width="85" height="42">
						年收益率：
					</td>
					<td width="185" height="42">
						<s:textfield id="rate" name="calculator.rate" cssClass="input02 validate[required,custom[number],min[0.1],max[1000]]" />&nbsp;%&nbsp; 年利率(月利率乘以12)
					</td>
				</tr>
				<tr>
					<td  width="85" height="42" >
						计息方式
					</td>
					<td  width="185" height="42">
						<s:select list="#{1:'等额本息 ',2:'一次性还本付息',3:'每月还息到期还本'}" name="calculator.model" listKey="key" listValue="value"  cssClass="select02" id="product_profitmode" />			
					</td>
				</tr>
				<tr>
					<td width="85" height="42">
						&nbsp;
					</td>
					<td width="185" height="42">
						<input type="submit" value="开始计算" class="btn_js" />
					</td>
					 
				</tr>
			</table>
	    </s:form>
		<p class="jsjg_tpc">
			计算结果
			<font color="#999">（仅供参考）</font>
		</p>
		<p class="jsjg_txt">
			总利息：
			<font color="#ff671c">0.00 元</font>
		</p>
		<p class="jsjg_txt">
			每月本息：
			<font color="#ff671c">0.00 元</font>
		</p>
	</div>
</div>
<div class="clear"></div>
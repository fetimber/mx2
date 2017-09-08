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
		<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
		<style type="text/css">
			* {font-family:"Courier New","微软雅黑"}
			.btn_tj_w{
				width:218px;
			}.ui-selectmenu-button span.ui-selectmenu-text{
			line-height:22px;
			}
		</style>
		<script type="text/javascript">
			
			$(function() {
			    $("select").selectmenu({width:'440px'});

				$("#save").click(function() { 
		               vaildFormSubmit(0);
			    }); 
	
	           	$("#save1").click(function() { 
		               vaildFormSubmit(1);
			    }); 
			    
			    $("#base_frm").validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1', maxErrorsPerField: true,
					autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
			     });
			    
	           	function vaildFormSubmit(flag){   
			       if($("#base_frm").validationEngine('validate')){	 
	      			  if(flag == 0){
                         $('#check').val("0");
                      } 	
		              $("#base_frm").submit();		     
	                }
			    }
			    
			 });
		
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />困难职工库&nbsp;>&nbsp;困难职工管理&nbsp;>&nbsp;
			 <s:if test="null == worker.id">
		     	新增困难员工
			</s:if>
			<s:else>
			          修改困难职工
			</s:else>
		</div>
		<s:form action="govworker!save_poor" namespace="/admin" method="post" id="base_frm">
		    <s:hidden name="worker.id" />
		    <s:hidden name="workerPoor.id" />
		    <s:hidden id="check" name="workerPoor.checkFlag" />
		    
			<div class="hid_files_div"></div>
		
			<table width="95%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						姓名
					</td>
					<td width="84%">
						<s:textfield name="worker.workerName" cssClass="input_1 input_1_w validate[required,minSize[1],maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td width="16%" align="right">
						所属单位
					</td>
					<td width="84%">
						<s:if test="null == #session.userinfo_in_session.unitInfo">
						   <label for="number"></label>
						   <s:select id="unitList"  name="worker.unitId"  list="#request.units" headerKey="" headerValue="请选择单位" listKey="id" listValue="unitName" ></s:select>
						</s:if>
					   <s:else>
					      <s:property value="#session.userinfo_in_session.unitInfo.unitName"/>
					   </s:else>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						性别
					</td>
                    <td>
					    <label for="number"></label>
						<s:select  name="worker.workerSex"  list="#{'男':'男','女':'女'}"></s:select>
					  </td>
				      </tr>
			     <tr>
					<td align="right">
						年龄
					</td>
					<td>
					   <s:textfield name="worker.workerAge" cssClass="input_1 input_1_w validate[required,custom[number],min[16],max[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						身份证号
					</td>
					<td>
					  <s:if test="null == worker.id">
					     <s:textfield name="worker.workerIdnumber" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[18]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					  </s:if>
					  <s:else>
					      <s:textfield name="worker.workerIdnumber" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[18]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					  </s:else>
					</td>
				</tr>
				<tr>
					<td align="right">
						银行卡号
					</td>
					<td>
					   <s:textfield name="worker.bankCard" cssClass="input_1 input_1_w validate[minSize[10],maxSize[20]]"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭地址
					</td>
					<td>
					   <s:textfield name="worker.workerAddress" cssClass="input_1 input_1_w validate[maxSize[256]"></s:textfield>&nbsp;&nbsp;<span style="color:red">最大250个字</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						手机号码
					</td>
					<td>
					   <s:textfield name="worker.workerPhone" cssClass="input_1 input_1_w validate[custom[phone]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
						
				<tr>
					<td align="right">
						备注荣誉
					</td>
					<td>
					   <s:textfield name="worker.honorRemark" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭人数
					</td>
					<td>
					   <s:textfield name="workerPoor.familyPeople" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭年人均月收入
					</td>
					<td>
					   <s:textfield name="workerPoor.familyIncome" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;元
					</td>
				</tr>
				
				
				
<!-- 					<tr> -->
<!-- 					<td align="right"> -->
<!-- 						填报单位 -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 					   <s:textfield name="workerPoor.inUnit" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp; -->
<!-- 					</td> -->
<!-- 				</tr> -->
				
<!-- 								<tr> -->
<!-- 					<td align="right"> -->
<!-- 						审核单位 -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 					   <s:textfield name="workerPoor.checkUnit" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp; -->
<!-- 					</td> -->
<!-- 				</tr> -->
				<tr>
					<td align="right">
						职工身份
					</td>
					<td>
					  <s:select  name="worker.workDuty"  list="#{'正式在职':'正式在职','劳务派遣':'劳务派遣','其他':'其他'}"></s:select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						困难标准
					</td>
					<td>
					   <s:select  name="workerPoor.poorLevel"  list="#{'家庭人均收入低于当地居民最低生活保障线的困难职工家庭':'家庭人均收入低于当地居民最低生活保障线的困难职工家庭','家庭人均收入略高于低保标准但因一定原因导致生活困难的困难职工家庭':'家庭人均收入略高于低保标准但因一定原因导致生活困难的困难职工家庭','因意外事件、重大疾病、自然灾害等造成生活困难的职工家庭':'因意外事件、重大疾病、自然灾害等造成生活困难的职工家庭'}"></s:select>
					</td>
				</tr>

                  <tr>
					<td align="right">
						致困原因
					</td>
					<td>
					  <s:select  name="workerPoor.poorReason"  list="#{'因病':'因病','因灾':'因灾','其他':'其他'}"></s:select>
					  
					</td>
				</tr>

		       <tr>
					<td align="right">
						说明
					</td>
					<td>
					   <s:textfield name="workerPoor.changeMemo" cssClass="input_1 input_1_w validate[maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">* 最大100个字</span>
					</td>
				</tr>
           	
           	   <s:if test="null != worker.id">
				  <s:if test="null != workerPoor.checkFlag">
					  <tr>
						<td align="right">
							审核状态
						</td>
						<td>
						     <s:if test="workerPoor.checkFlag == 0">未审核</s:if>
						     <s:if test="workerPoor.checkFlag == 1">审核通过</s:if>
							 <s:if test="workerPoor.checkFlag == 2">审核拒绝</s:if>
						</td>
					  </tr>
				   </s:if>
				
					 <s:if test="null != workerPoor.checkDesc">
						  <tr>
							<td align="right">
								审核意见
							</td>
							<td>
							    <s:property value="workerPoor.checkDesc"/>
							</td>
						  </tr>
					</s:if>
               </s:if>
           
               <s:if test="null != worker.id">
                  <s:if test="null != workerPoor.sendTime">
                	<tr>
						<td align="right">
							物资发放时间
						</td>
						<td>
	                      <s:date name="%{workerPoor.sendTime}" format="yyyy-MM-dd" />    
						</td>		
				    </tr>
				 </s:if>
				 <s:if test="null != workerPoor.sendDept">
					<tr>
						<td align="right">
						发放主管部门
						</td>
						<td>
						    <s:property value="workerPoor.sendDept"/>
						</td>
					</tr>
			     </s:if>
				 <s:if test="null != workerPoor.sendThing">
			    <tr>  
					<td align="right">
						物资
					</td>
					<td>
					   <s:property value="workerPoor.sendThing"/>
					</td>
				</tr>
				</s:if>
				<s:if test="null != workerPoor.sendRemark">
				 <tr>  
					<td align="right">
						发放记录
					</td>
					<td>
					   <s:textarea cols="52" rows="20" name="workerPoor.sendRemark" ></s:textarea> 
					</td>
				</tr>
				</s:if>
              </s:if>
			 <tr>
			    <td align="right">&nbsp;</td>
			    <td height="60"> 
			       <input type="submit" name="button" id="save" value="提交"  class="btn_tj btn_tj_w"/>
			     
			      <input type="submit" name="button" id="save1" value="保存"  class="btn_tj btn_tj_w"/>
			      <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/></td>
			  </tr>
			</table>

		</s:form>
		
	</body>
</html>
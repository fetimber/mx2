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
		     .input_1{width:160px;}
			.tab1 td{font-family: "Courier New","微软雅黑"}
			#base_frm_project_area-button{height: 30px;margin-left: 15px;}
			.tab1 td{font-family:'Courier New','微软雅黑'}
			.ui-selectmenu-button span.ui-selectmenu-text{
			line-height:22px;
			}
		</style>
		<script type="text/javascript">
		    var flag = false;
			$(function(){
					$(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true
				});
				$("select").selectmenu({width:"110px"});
				
				$(".importexcel").bind("click",function(){
					$("#upload_btn_1").trigger("click");
				});
				
				_init_upload(1);
			});
			
			function _forward_page(page){
			    $("#base_frm").attr('action','admin/govhonorunit!view');
				$("#page_current").val(page);
				$("#base_frm").submit();
			}
			
			function exportData(){
				$("#base_frm").attr('action','admin/govhonorunit!export?checkFlag=0');
				$("#base_frm").submit();
			}
			
			function _init_upload(idx){
				$("#upload_btn_" + idx).bind("change",function(){
					var dialog = $.dialog({
					    icon: 'loading.gif',
					    titleIcon: 'lhgcore.gif',
					    content: '正在导入数据，请稍候....'
					});
					$.ajaxFileUpload({
						url: 'admin/upload!excel',
						//用于文件上传的服务器端请求地址
						secureuri: false,
						//是否需要安全协议，一般设置为false
						data: {
							createMedia: false,
							saveFile:true,
							fileType:99
						},
						fileElementId: 'upload_btn_' + idx,
						//文件上传域的ID
						dataType: 'json',
						//返回值类型 一般设置为json
						success: function(data) { //服务器成功响应处理函数
							dialog.close();
							if (data.result) {
							   $.dialog.tips("文件导入成功 ",2,'success.gif',function(){
							   });
							   window.location.reload(true);
							} else {
								$.dialog.tips("文件导入失败，请使用模板填写正确 再上传....", 3, "error.gif");
							    window.location.reload(true);
							}
							
						},
						error: function(data, status, e) { //服务器响应失败处理函数
							dialog.close();
							$.dialog.tips("文件导入失败，请稍候再试....", 2, "error.gif");
						}
					});
				});
			}		
			
			function delete_honor(id,name){
			    $.dialog.confirm("你确定要删除此单位荣誉信息[" + name + "]吗？<br /><br />删除后，将不再显示此信息，请谨慎操作。", function(){
				   $.get("admin/govhonorunit!delete",{"honor.id":id},function(data){
					   eval("data=" + data);
					   if(data.result){
						   $.dialog.tips("数据操作成功",2,'success.gif',function(){
							   window.location.reload(true);
						   });
					   } else {
						   $.dialog.tips("服务器繁忙，数据操作失败，请稍后再试",2,'error.gif');
					   }
				   });
				});
			}
			
			function checkHonor(honorrid,name,flag){
			     var tip = "你确定要审核";
			     var checkflag = "";
			     if(flag == "pass"){
			        tip += "通过";
			        checkflag = "1";
			     }else{
			        tip += "拒绝";
			        checkflag = "2";
			     }
			     tip += " 单位荣誉 [" + name + "]吗？<br /><br />";
			     
			     
			     $.dialog.confirm(tip, function(){
				   $.get("admin/govhonor!check",{"honor.id":honorrid,"honor.checkFlag":checkflag},function(data){
					   eval("data=" + data);
					   if(data.result){
						        $.dialog.tips("审核操作成功",2,'success.gif',function(){
							    window.location.reload(true);
						   });
					   } else {
						   $.dialog.tips("服务器繁忙，数据操作失败，请稍后再试",2,'error.gif');
					   }
				   });
				});
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />荣誉单位库&nbsp;>&nbsp;单位荣誉管理
		</div>
		<div class="m_w">
<!-- 		    <div class="p_tpc" onclick="showSearch();" style="cursor: pointer;">搜索条件:</div> -->
			<!--检索部分-->
			<s:form action="govhonorunit!view" namespace="/admin" id="base_frm">
			<s:hidden name="page.current" id="page_current"></s:hidden>
			<div class="tab_check"  id="search" >
			    <table class="tab11" width="100%"> 
						<tr>
							<td align="right">请输入搜索关键字:</td>
							<td colspan="3">
							    <s:textfield name="query.keyword" cssClass="auto_tips input_1" alt="单位名称、所在地、主要事迹、电话、负责人、主席" style="margin-top:-2px;width:686px;border:1px solid #aaa;height:29px;line-height:29px;padding:1px 5px;"></s:textfield>
							</td>
						</tr>

						<tr>
							<td align="right">获奖检索开始时间:</td>
							<td><input name="query.honorTimeStart" type="text" class="input_1 timer" value="<s:date name="%{query.lastProcessTimeStart}" format="yyyy-MM-dd" />" /></td>
							<td align="right">获奖检索结束时间:</td>
							<td><input name="query.honorTimeEnd" type="text" class="input_1 timer" value="<s:date name="%{query.lastProcessTimeEnd}" format="yyyy-MM-dd" />" /></td>
						</tr>

						<tr>
						 <td> &nbsp; </td>
						 <td   align="right">
						  	   <s:select name="query.honorType" list="#{'':'荣誉种类','五一劳动奖状':'五一劳动奖状','工人先锋号':'工人先锋号','巾帼示范（标兵）岗':'巾帼示范（标兵）岗','劳模创新工作室':'劳模创新工作室','“安康杯”竞赛先进集体':'“安康杯”竞赛先进集体','职工书屋示范点':'职工书屋示范点','工会工作先进单位':'工会工作先进单位','其他':'其他'}"></s:select><span>&nbsp;</span> <span>&nbsp;</span> 
				               <s:select name="query.check" list="#{'':'审核状态','-2':'未提交','0':'未审核',1:'审核通过',2:'审核拒绝'}" ></s:select><span>&nbsp;</span> <span>&nbsp;</span> 
				 		</td>	
						
						<td  colspan="2">
						     <input  type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)"/>
						     <input  type="button" value="新增" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/govhonorunit!add'"/>
					      
					         <input  type="button" value="导出" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="exportData();"/>
				           
						  </td>
						</tr>
					</table>
				   </div>
			</s:form>
	
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
				<tr>
					<th width="5%">
						序号
					</th>
					<th width="10%">
						单位名称
					</th>
					<th width="10%">
					           所在地
					</th>
					<th width="13%">
						单位负责人
					</th>
					<th width="10%">
						工会主席
					</th>
					<th width="10%">
						岗位责任人
					</th>
					<th width="10%">
						荣誉种类
					</th>
					<th width="10%">
						标题文号
					</th>
					<th width="10%">
						审核状态
					</th>
					<th width="15%">
						操作
					</th>
				</tr>
				<s:if test="null != page.beans && page.beans.size()>0">
				<s:iterator value="#request.page.beans" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td align="center" valign="top">
							<s:property value="%{#request.page.start + #st.count}" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.honorUnit" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.unitLocation" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.unitDuty" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.unitLeader" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.honorDuty" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.honorType" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.honorTitle" />
						</td>
						<td align="center" valign="top">
						    <s:if test="#item.checkFlag == null || #item.checkFlag == ''">未提交</s:if>
						    <s:elseif test="#item.checkFlag == 0">未审核</s:elseif>
							<s:elseif test="#item.checkFlag == 1">审核通过</s:elseif>
							<s:elseif test="#item.checkFlag == 2">审核拒绝</s:elseif>
						</td>
						<td align="center" valign="top">
                              <a href="admin/govhonorunit!detail?honor.secId=<s:property value="#item.secId" />">详情</a>
                              <s:if test="#item.checkFlag == null || #item.checkFlag == '' || #item.checkFlag == 2">
                              |  <a href="admin/govhonorunit!add?honor.secId=<s:property value="#item.secId" />">修改</a>
                              |  <a href="javascript:delete_honor(<s:property value="#item.id" />,'<s:property value="#item.honorTitle" />')">删除</a>
                              </s:if>
                       </td>

					</tr>
				</s:iterator>
				</s:if>
					<s:else>
						<tr>
							<td colspan="11" align="center">
								<font style="color:#ff671c;">
									没查询到您想要的数据信息！！
								</font>
							</td>
						</tr>
					</s:else>
			</table>
			<!--页码-->
			<div class="page">
			<s:include value="../common/page.jsp"></s:include>
			</div>
		</div>
		
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_1" name="upload" />
		</div>
		
	</body>
</html>
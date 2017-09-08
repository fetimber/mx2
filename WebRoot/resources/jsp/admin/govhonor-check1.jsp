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
			}
		</style>
		<script type="text/javascript">
			var big_pictures = new Array();
			
			
			$(function() {
			    <s:if test="null != honor && null != honor.bigPictures">
					<s:iterator value="honor.bigPictures" var="item">
						big_pictures.push({"id":<s:property value="#item.id" />,"path":"<s:property value="#item.filePath" />"});
					</s:iterator>
				</s:if>
			
			    $(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true
				});
				
				$("select").selectmenu({width:'440px'})
	          	$("#workerList").selectmenu({change: _workerList_change});
			
			    
// 			    if($("#unitList").attr("name") != undefined){
// 			      $("#unitList").selectmenu({change: _unitList_change});
// 			    }
			    
	          	//_workerList_change();
	          	
	          	$(".btn_upload:eq(0)").bind("click",function(){
					$("#upload_btn_1").trigger("click");
				});
				
				_init_upload(1);
				auto_size();
			
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				}).bind("jqv.form.result",function(event, errorFound){
					var div = $(".hid_files_div").html('');
					$.each(big_pictures,function(idx,item){
						$("<input>").attr("type","hidden").attr("name","bigPictures[" + idx + "]").val(item.id).appendTo(div);
					});					
				});
				
			
	          	
			});
		function _init_upload(idx){
				$("#upload_btn_" + idx).bind("change",function(){
					var dialog = $.dialog({
					    icon: 'loading.gif',
					    titleIcon: 'lhgcore.gif',
					    content: '正在上传图片，请稍候....'
					});
					$.ajaxFileUpload({
						url: 'admin/upload',
						//用于文件上传的服务器端请求地址
						secureuri: false,
						//是否需要安全协议，一般设置为false
						data: {
							createMedia: false,
							saveFile:true,
							fileType:2
						},
						fileElementId: 'upload_btn_' + idx,
						//文件上传域的ID
						dataType: 'json',
						//返回值类型 一般设置为json
						success: function(data) { //服务器成功响应处理函数
							dialog.close();
							if (data.result) {
								var pic = {"id":data.id,"path":data.upload_path,"width":data.width,"height":data.height};
								if(idx == 1){
									big_pictures.push(pic);
								} 
								rebuild_pict(pic,idx);
							} else {
								$.dialog.tips("文件格式错误，请使用jpg格式图片", 2, "error.gif");
							}
							$("#upload_btn_" + idx).replaceWith("<input type='file' name='upload' value='' title='" + Math.random() + "' id='upload_btn_" + idx + "'/>");
							_init_upload(idx);
						},
						error: function(data, status, e) { //服务器响应失败处理函数
							dialog.close();
							$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
						}
					});
				});
			}	
			
		function auto_size() {
				$(".upload_imgs_1 img").each(function() {
					AutoResizeImage(800, 600, this);
				});
			}
			function rebuild_pict(pic,idx){
				var span = $("<span>").attr("pic_id",pic.id);
				if(idx == 1){
					if(big_pictures.length == 1){
						$(".upload_imgs_1").remove();
					}
					span.addClass("upload_imgs_1 bigpic");
				} 
				var img = $("<img>").attr("pic_id",pic.id).attr("src",pic.path).width(pic.width).height(pic.height).bind("load",function(){
					if(idx == 1){
						AutoResizeImage(800,600, this);
					} 
				});
				var close = $("<a>").addClass("img_close").attr("href","javascript:delete_img(" + idx + "," + pic.id + ")");
				span.append(img).append(close);
				if(idx == 1){
					span.appendTo("#big_imgs");
				}
			}
			function delete_img(idx,pic_id){
				var div = "";
				if(idx == 1){
					div = ".bigpic";
				} 
				$(div + "[pic_id=" + pic_id + "]").remove();
				var index = -1;
				var list = null;
				if(idx == 1){
					list = big_pictures;
				}
				
				for(var i = 0; i < list.length; i++){
					if(list[i].id == pic_id){
						index = i
						break;
					}
				}
				
				if(index > -1){
					if(idx == 1){
						big_pictures.splice(index,1);
					}
				}
				if(idx == 1){
					if(big_pictures.length == 0){
						$("<span>").addClass("upload_imgs_1").appendTo("#big_imgs");
					}
				}
			}	
			
	    function _workerList_change(){
   
	        var postParams = "worker.id=" + $("#workerList").val();
	    
	    if($("#workerList").val() != ""){
	        $.post('admin/govhonor!showorker', postParams ,function(data){
				    eval("data=" + data);

					$('#workersex').val(data.result.workerSex);
					$('#workersex').find(".option[text='" + data.result.workerSex +"']").attr("selected","selected");
	                $('#workersex-button .ui-selectmenu-text').text(data.result.workerSex);
	    
					$('#workerage').val(data.result.workerAge);
					$('#workeridnumber').val(data.result.workerIdnumber);
					
				    $('#workeridnumber').removeClass("input_1 input_1_w validate[required,minSize[10],maxSize[18],ajax[_ajax_id_card]]]");
					$('#workeridnumber').addClass("input_1 input_1_w validate[required,minSize[10],maxSize[18]]");
				
					$('#workerbankcard').val(data.result.bankCard);
					$('#workeraddress').val(data.result.workerAddress);
		
					$('#workerduty').val(data.result.workDuty);
					$('#workerduty').find(".option[text='" + data.result.workDuty +"']").attr("selected","selected");
	                $('#workerduty-button .ui-selectmenu-text').text(data.result.workDuty);
	                $('#workername').val(data.result.workerName); 
	                $('#workerphone').val(data.result.workerPhone); 
	                $('#workerid').val($("#workerList").val()); 
			});
	    }else{
	       	$('#workersex').val('男');
			$('#workerage').val('');
			$('#workeridnumber').val('');
			$('#workerbankcard').val('');
			$('#workeraddress').val('');
			$('#workerduty').val('正式在职');
			$('#workeraddress').val('');
			$('#workername').val(''); 
			
			$('#workeridnumber').removeClass("input_1 input_1_w validate[required,minSize[10],maxSize[18]]");
			$('#workeridnumber').addClass("input_1 input_1_w validate[required,minSize[10],maxSize[18],ajax[_ajax_id_card]]]");
		   
		    $('#workerid').val(''); 
		    $('#workerphone').val(''); 
	    }

       }
       
         function _unitList_change(){
   
	        var postParams = "unit.id=" + $("#unitList").val();
	    
	       if($("#unitList").val() != ""){
	        $.post('admin/govhonor!showunit', postParams ,function(data){
				    eval("data=" + data);
					$('#unitduty').val(data.result.unitDuty);
					var formattime = data.result.joinTime.substring(0,data.result.joinTime.indexOf('T'))	           
	                $('#unitjointime').val(formattime); 
	                     
			});
	    }else{
	       	$('#unitduty').val('');
			$('#unitjointime').val('');
	    }

       }
       
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />获奖职工库&nbsp;>&nbsp;获奖职工审核&nbsp;>&nbsp;
			 <s:if test="null == honor.id">
		     	新增获奖职工
			</s:if>
			<s:else>
			          发放获奖职工奖励物资
			</s:else>	
		</div>
		<s:form action="govhonor!save" namespace="/admin" method="post" id="base_frm">
		    <s:hidden name="worker.id" id="workerid"/>
		    <s:hidden name="honor.id" />
		    <s:hidden name="checkFlag" value="1"/>
		  
			<div class="hid_files_div"></div>
		
			<table id="info" width="95%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						获奖职工
					</td>
					<td width="84%">
						<s:select id="workerList"  name="honor.honorWorker"  list="#request.workers" headerKey="" headerValue="请填写员工信息或选择职工" listKey="id" listValue="workerName" ></s:select>	
					</td>
				</tr>
						
			  	<tr>
					<td width="16%" align="right">
						职工姓名
					</td>
					<td width="84%">
						 <s:textfield id="workername" name="worker.workerName" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
				    </td>
				</tr>			
						
						
				<tr>
					<td align="right">
						性别
					</td>
                    <td>
					    <label for="number"></label>
						<s:select  id="workersex" name="worker.workerSex"  list="#{'男':'男','女':'女'}"></s:select>
					  </td>
				      </tr>
			     <tr> 
					<td align="right">
						年龄
					</td>
					<td>
					   <s:textfield id="workerage" name="worker.workerAge" cssClass="input_1 input_1_w validate[required,custom[number],min[16],max[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						身份证号
					</td>
					<td id="workeridnumbertd">
					    <s:if test="null == honor.id">
					       <s:textfield id="workeridnumber" name="worker.workerIdnumber" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[18],ajax[_ajax_id_card]]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					    </s:if>
					    <s:else>
					       <s:textfield id="workeridnumber" name="worker.workerIdnumber" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[18]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					    </s:else>
					</td>
				</tr>
				<tr>
					<td align="right">
						银行卡号
					</td>
					<td>
					   <s:textfield  id="workerbankcard" name="worker.bankCard" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[20]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭地址
					</td>
					<td>
					   <s:textfield  id="workeraddress" name="worker.workerAddress" cssClass="input_1 input_1_w validate[required,maxSize[256]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						职工身份
					</td>
					<td>
					  <s:select id="workerduty" name="worker.workDuty"  list="#{'正式在职':'正式在职','劳务派遣':'劳务派遣','其他':'其他'}"></s:select>
					</td>
				</tr>
				
				
				<tr>
					<td align="right">
						联系电话
					</td>
					<td>
					   <s:textfield  id="workerphone" name="worker.workerPhone" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				

				<tr>
					<td width="16%" align="right">
						获奖时间
					</td>
					<td width="84%">
						<input name="honor.honorTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{honor.honorTime}" format="yyyy-MM-dd" />" />&nbsp;&nbsp;<span style="color:red">*</span>
                     </td>
				</tr>
 				
				<tr>
					<td align="right">
						荣誉种类
					</td>
                    <td>
					    <label for="number"></label>
						<s:select  name="honor.honorType"  list="#{'劳模（先进工作者）':'劳模（先进工作者）','巾帼标兵':'巾帼标兵','五一劳动奖章':'五一劳动奖章','文明职工':'文明职工','“安康杯”竞赛先进个人':'“安康杯”竞赛先进个人','优秀工会工作者':'优秀工会工作者'}"></s:select>
					  </td>
				      </tr>
			     <tr>
					<td align="right">
						荣誉级别
					</td>
					 <td>
					    <label for="number"></label>
						<s:select  name="honor.honorLevel" list="#{'全国':'全国','省级':'省级','市级':'市级'}"></s:select>
					  </td>
				</tr>
				
				<tr>
					<td align="right">
					          个人主要事迹
					</td>
					<td>
					   <s:textfield name="honor.honorDesc" cssClass="input_1 input_1_w validate[required,maxSize[256]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td width="16%" align="right">
						所属单位
					</td>
					<td width="84%">
						<s:if test="null == #session.userinfo_in_session.unitInfo">
						   <label for="number"></label>
						   <s:select id="unitList"  name="honor.inUnit"  list="#request.units"  listKey="id" listValue="unitName" ></s:select>
						</s:if>
					   <s:else>
					      <s:property value="#session.userinfo_in_session.unitInfo.unitName"/>
					   </s:else>
					</td>
				</tr>
				
				<tr>
					<td align="right">
					        成立时间
					</td>
					<td>	    
					    <input name="honor.joinTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{honor.joinTime}" format="yyyy-MM-dd" />" />
					    &nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
					          负责人
					</td>
					<td>
						  <s:textfield id="unitduty" name="honor.unitDuty" cssClass="input_1 input_1_w validate[required,maxSize[255]]"></s:textfield>
						  &nbsp;&nbsp;<span style="color:red">*</span>     
					</td>
				</tr>
				
				<tr>
					<td align="right">
					          集体主要事迹
					</td>
					<td>
					   <s:textfield name="honor.unitHonorDesc" cssClass="input_1 input_1_w validate[required,maxSize[255]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						表彰文件签发单位标题文号
					</td>
					<td>
					   <s:textfield name="honor.honorTitle" cssClass="input_1 input_1_w validate[required,maxSize[256]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
			   <tr>
					<td align="right">
						奖章编号
					</td>
					<td>
					   <s:textfield name="honor.honorCode" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						奖励发放时间
					</td>
					<td>
						<input name="honor.sendTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{honor.sendTime}" format="yyyy-MM-dd" />" />&nbsp;&nbsp;<span style="color:red">*</span>
                     </td>		
				</tr>
				
				<tr>
					<td align="right">
						奖励发放主管部门
					</td>
					<td>
					   <s:textfield name="honor.sendDept" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
			    <tr>  
					<td align="right">
						奖励物品
					</td>
					<td>
					   <s:textfield name="honor.sendThing" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						荣誉附件：
					</td>
					<td > 
						<input type="button"  value="上传附件" class="btn_upload" />&nbsp;&nbsp;&nbsp;&nbsp;<span class="gray">附件类型支持jpg图片格式</span>
					</td>
				</tr>
				
				
				
				
				<tr>
					<td  align="right">
						
					</td>
					<td valign="top" style="padding-top:0;" id="big_imgs">
						<s:if test="null == honor">
							<span class="upload_imgs_1"></span>
						</s:if>
						<s:elseif test="null == honor.bigPictures">
							<span class="upload_imgs_1"></span>
						</s:elseif>
						<s:else>
							<s:iterator value="honor.bigPictures" var="item">
								<span pic_id="<s:property value="#item.id" />" class="upload_imgs_1 bigpic">
								<a href="javascript:delete_img(true,<s:property value="#item.id" />)" class="img_close"></a>
								<img style="width: 800px; height: 600px;" src="<s:property value="#item.filePath" />" pic_id="<s:property value="#item.id" />"></span>
							</s:iterator>
						</s:else>
					</td>
				</tr>
				
					
			 <tr>
			    <td align="right">&nbsp;</td>
			    <td height="60"> 
			     <s:if test="null == honor.id">
			     <input type="submit" name="button" id="save" value="提交"  class="btn_tj btn_tj_w"/>
			      </s:if>
			      <s:else>
			       <input type="submit" name="button" id="save" value="发放"  class="btn_tj btn_tj_w"/>    
			      </s:else>
			    <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/></td>
			  </tr>
			</table>

		</s:form>
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_1" name="upload" />
		</div>
	</body>
</html>
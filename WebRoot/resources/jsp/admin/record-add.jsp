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
			    <s:if test="null != record && null != record.bigPictures">
					<s:iterator value="record.bigPictures" var="item">
						big_pictures.push({"id":<s:property value="#item.id" />,"path":"<s:property value="#item.filePath" />"});
					</s:iterator>
				</s:if>
			
			    $(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true,
					maxDate: new Date()
				});
				
				
				$("select").selectmenu({width:'440px'})
	          	//$("#workerList").selectmenu({change: _workerList_change});
			
			

			    
			    $("#save1").click(function() { 
		               vaildFormSubmit(1);
			    }); 
			    
	          	
	          	$(".btn_upload:eq(0)").bind("click",function(){
					$("#upload_btn_1").trigger("click");
				});
				
				_init_upload(1);
				auto_size();
			
				$('#base_frm').validationEngine({
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000				}).bind("jqv.form.result",function(event, errorFound){
					var div = $(".hid_files_div").html('');
					$.each(big_pictures,function(idx,item){
						$("<input>").attr("type","hidden").attr("name","bigPictures[" + idx + "]").val(item.id).appendTo(div);
					});					
				});
				
			    function vaildFormSubmit(flag){   
			      if($("#base_frm").validationEngine('validate')){	 		       
//                       if(flag == 0){
//                          $('#check').val("0");
//                       }
                       
//                      if($('#honorTime').val() > $('#createTime').val() || $('#honorTime').val() > new Date()){
//                        $.dialog.tips('获奖必须小于创建时间',3.0,'error.gif');
//                        return false;
//                      }

				     $("#base_frm").submit();		     
			      }
			    }
			
	          	
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
							fileType:7
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
       
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />困难职工库&nbsp;>&nbsp;困难职工管理&nbsp;>&nbsp;
			 <s:if test="null == record.id">
		     	新增发放记录
			</s:if>
			<s:else>
			          修改发放记录
			</s:else>	
		</div>
		<s:form action="record!save" namespace="/admin" method="post" id="base_frm">
		    <s:hidden name="record.id" />
		    <s:hidden name="record.workPoorId" />
			<div class="hid_files_div"></div>
		
			<table id="info" width="95%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				
			  	<tr>
					<td width="16%" align="right">
						现金
					</td>
					<td width="84%">
						 <s:textfield name="record.goodsCash" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp;
				    </td>
				</tr>
				
				<tr>
					<td width="16%" align="right">
						物资折合人民币
					</td>
					<td width="84%">
						 <s:textfield name="record.goodsValue" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp;
				    </td>
				</tr>	
					
			    <tr>
					<td width="16%" align="right">
					        发送部门
					</td>
					<td width="84%">
						 <s:textfield  name="record.sendDept" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
				    </td>
				</tr>	
				
				<tr>
					<td width="16%" align="right">
						发送物品
					</td>
					<td width="84%">
						 <s:textfield  name="record.sendThing" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
				    </td>
				</tr>
				
				<tr>
					<td width="16%" align="right">
						发送描述
					</td>
					<td width="84%">
						 <s:textfield  name="record.sendRemark" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
				    </td>
				</tr>	
				
					
				<tr>
					<td width="16%" align="right">
						发送时间
					</td>
					<td width="84%">
						<input  name="record.sendTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{send.sendTime}" format="yyyy-MM-dd" />" />&nbsp;&nbsp;<span style="color:red">*</span>
                     </td>
				</tr>
 				
				
				<tr>
					<td align="right">
						发送附件：
					</td>
					<td > 
						<input type="button"  value="上传附件" class="btn_upload" />&nbsp;&nbsp;&nbsp;&nbsp;<span class="gray">附件类型支持jpg图片格式</span>
					</td>
				</tr>
				<tr>
					<td  align="right">
						
					</td>
					<td valign="top" style="padding-top:0;" id="big_imgs">
						<s:if test="null == record">
							<span class="upload_imgs_1"></span>
						</s:if>
						<s:elseif test="null == record.bigPictures">
							<span class="upload_imgs_1"></span>
						</s:elseif>
						<s:else>
							<s:iterator value="record.bigPictures" var="item">
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
			      <input type="submit" name="button" id="save1" value="保存"  class="btn_tj btn_tj_w"/>
			      
			    <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/></td>
			  </tr>
			</table>

		</s:form>
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_1" name="upload" />
		</div>
	</body>
</html>
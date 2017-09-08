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
  	.input_1 {font-family:"Courier New","微软雅黑"}
  </style>
  <script type="text/javascript">
  $(function(){
		$('#auto_save_from').validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 10, +5',maxErrorsPerField: true,
			autoHideDelay:3000
		});
		$(".ar_tab li:eq(0)").bind("click",function(){
			$(".ar_tab li").removeClass("ar_tab_now");
			$(this).addClass("ar_tab_now");
			$(".ar_cont li:eq(0)").show();
			$(".ar_cont li:eq(1)").hide();
		});
		$(".ar_tab li:eq(1)").bind("click",function(){
			$(".ar_tab li").removeClass("ar_tab_now");
			$(this).addClass("ar_tab_now");
			$(".ar_cont li:eq(1)").show();
			$(".ar_cont li:eq(0)").hide();
		});
		$(".new_role_button").bind("click",function(){
			$(".new_role").slideDown();
		})
		ajax_upload(0);
		ajax_upload(1);
		<s:if test="null != #request.gz_auto && #request.gz_auto.contentType == 1">
			$("input:hidden[name='auto.contentType']:eq(1)").val(1);
			$("#upload_div_1").show();
			$(".txta1:eq(1)").hide();
		</s:if>
		auto_size();
  });
  function ajax_upload(idx){
	  var slt = "#upload_btn_" + idx;
	  $(slt).bind("change",function(){
		  	var dialog = $.dialog({
			    icon: 'loading.gif',
			    titleIcon: 'lhgcore.gif',
			    content: '正在上传图片，请稍候'
			});
	        $.ajaxFileUpload ({
	                url: 'admin/upload', //用于文件上传的服务器端请求地址
	                secureuri: false, //是否需要安全协议，一般设置为false
	                data:{createMedia:true},
	                fileElementId: 'upload_btn_' + idx, //文件上传域的ID
	                dataType: 'json', //返回值类型 一般设置为json
	                success: function (data)  { //服务器成功响应处理函数
	                    if(data.result){
	                    	$(".txta1:eq(" +idx+ ")").hide();
	                    	$("#upload_img_" + idx).attr("src",data.upload_path);
	                    	var isWidth = data.width - data.height > 0;
	                    	var width = data.width, height = data.height;
	                    	if(isWidth) {
	                    		if(width > 500) {
	                    			width = 500;
	                    			height = data.height * (500 / data.width);
	                    		} 
	                    	} else {
	                    		if(height > 500){
	                    			height = 500;
	                    			width = data.width * (500 / data.height);
	                    		}
	                    	}
	                    	$("#upload_img_" + idx).width(width).height(height);
	                    	$("#upload_div_" + idx).show();
	                    	$("input:hidden[name='auto.mediaId']:eq(" + idx + ")").val(data.mediaId);
	                    	$("input:hidden[name='auto.picUrl']:eq(" + idx + ")").val(data.upload_path);
	                    	auto_size();
	                    } else {
	                    	$.dialog.tips("文件上传失败",2,"error.gif");
	                    }
	                    $("#upload_btn_" + idx).replaceWith("<input type='file' name='upload' value='' title='" + Math.random() + "' id='upload_btn_" + idx + "'/>");
	                	ajax_upload(idx);
	                	dialog.close();
	                },
	                error: function (data, status, e) {//服务器响应失败处理函数
	                	dialog.close();
	                	$.dialog.tips("文件上传失败",2,"error.gif");
	                }
	            }
	        );
		});
  }
  function change_type(type_id,idx){
	  $("input:hidden[name='auto.contentType']:eq(" + idx + ")").val(type_id);
	  if(type_id==1){
		  $("#upload_btn_" + idx).trigger("click");
	  } else {
		  $("#upload_div_" + idx).hide();
		  $(".txta1:eq(" + idx + ")").show().focus();
	  }
  }
  function auto_size(){
	  $(".auto_size").each(function(){
		  AutoResizeImage(500,500,this);
	  });
  }
  function delete_id(id){
	  $.dialog.confirm('确认删除此数据吗？<br /><br />数据删除后不可恢复，请慎重操作',function(){
		  window.location.href = 'admin/config!setting_auto_delete?auto.id=' + id;
	  });
  }
  function opswitch(isOpen){
	  $.dialog.confirm("确定要" + (isOpen ? "开启" : "禁用") + "自动回复设置吗?",function(){
			$.get("admin/config!setting_auto_switch",{"config.autoSwitch":isOpen},function(data){
				eval("data=" + data);
				if(data.result){
					$.dialog.tips("微信配置修改成功，将重新加载数据",2,'success.gif',function(){
						window.location.reload(true);
					});
				} else {
					$.dialog.tips("微信配置修改失败[" + data.description + "]",2,'error.gif');
				}
			});
	  });
  }
  </script>
</head>
<body>
	<div class="home">
		<img src="resources/images/icon_home.png" width="20" height="20" />微信设置&nbsp;>&nbsp;自动回复设置
	</div>
	<div class="m_w">
		<div class="ar_p1">
			<img src="resources/images/icon_1.png" width="36" height="36" class="ar_img1" />
			<div class="ar_txt1">
				<p>
					<s:if test="config.autoSwitch">
						已开启自动回复设置
					</s:if>
					<s:else>自动回复已禁用</s:else>
				</p>
				<p>
					<font color="#999">
						通过编辑内容或关键词规则，快速进行自动回复设置
					</font>
				</p>
			</div>
			<s:if test="config.autoSwitch">
				<input type="button" value="停用" onclick="opswitch(false)" class="btn_search btn_ty_p" />
			</s:if>
			<s:else>
				<input type="button" value="启用" onclick="opswitch(true)" class="btn_search btn_ty_p" />
			</s:else>
			<div class="clear"></div>
		</div>
		<ul class="ar_tab">
			<li class="ar_tab_now">
				关键字回复[<s:if test="null == #request.keyword_autos">未设置</s:if><s:else>已设置</s:else>]
			</li>
			<li>
				关注自动回复[<s:if test="null != #request.gz_auto">已设置</s:if><s:else>未设置</s:else>]
			</li>
		</ul>
		<div class="clear"></div>
		<ul class="ar_cont">
			<li>
				<input type="button" value="添加规则" class="btn_addgz new_role_button" />
				<div class="new_role" style="display: none;">
					<div class="p1_tpc">
						新规则
					</div>
					<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
						<s:file id="upload_btn_0" name="upload" />
					</div>
					<div class="p1_cont p1_cont_p">
						<s:form action="config!setting_auto_save" namespace="/admin" id="auto_save_from">
							<s:hidden name="auto.contentType" value="2" />
							<s:hidden name="auto.mediaId" value="" />
							<s:hidden name="auto.picUrl" value="" />
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab_1">
								<tbody>
									<tr>
										<td width="9%" align="right">
											规则名：
										</td>
										<td width="91%">
											<input type="text" name="auto.roleName" class="input_1 input_1_w validate[required,minSize[2],maxSize[60]]" />
											<span class="f_gray">
												&nbsp;&nbsp;规则名最多60个字
											</span>
										</td>
									</tr>
									<tr>
										<td align="right">
											关键字：
										</td>
										<td>
											<input type="text" name="auto.keyword" class="input_1 input_3_w validate[required,minSize[1],maxSize[60]]" />
										</td>
									</tr>
									<tr>
										<td align="right">
											&nbsp;
										</td>
										<td valign="top" style="padding:0 8px">
											<span class="f_gray">
												每个关键字规则只能输入一个关键字
											</span>
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											回复：
										</td>
										<td>
											<textarea name="auto.content" cols="45" rows="5" class="txta1"></textarea>
											<div style="width: 818px;border: 1px solid #AAA;padding: 5px;display:none" id="upload_div_0"><img src="#" alt="" class="auto_size"  id="upload_img_0" /></div>
											<div class="opr1">
												<img src="resources/images/opr_img4.png" width="24" height="24" alt="文字消息" onclick="change_type(2,0)" />
												<img src="resources/images/opr_img1.png" width="24" height="24" alt="图片消息" onclick="change_type(1,0)" />
												<!-- 
												<img src="resources/images/opr_img2.png" width="24" height="24" />
												<img src="resources/images/opr_img3.png" width="24" height="24" />
												-->
											</div>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
										<td>
											<input type="submit" value="保存" class="btn_tj btn_w2" />
											
										</td>
									</tr>
								</tbody>
							</table>
						</s:form>
					</div>
				</div>
				<s:iterator value="#request.keyword_autos" var="item">
					<div class="p1_tpc">
						<span class="p1_tpc_txt"><s:property value="#item.roleName"  /></span><a href="javascript:delete_id(<s:property value="#item.id" />)" class="p_del">删除</a>
						<div class="clear"></div>
					</div>
					<div class="p1_cont p1_cont_p">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab_1">
							<tr>
								<td width="9%" align="right">
									关键词：
								</td>
								<td width="91%" align="left">
									<s:property value="#item.keyword" />
								</td>
							</tr>
							<tr>
								<td align="right">
									回复：
								</td>
								<td align="left">
									<s:if test="#item.contentType == 1">
										<img src="<s:property value="#item.picUrl" />" class="auto_size"/>
									</s:if>
									<s:else>
										<s:property value="#item.content" />
									</s:else>
								</td>
							</tr>
						</table>
					</div>
				</s:iterator>				
			</li>
			<li style="display:none;">
					<div class="p1_tpc">
						微信用户关注公众号时自动发送的内容
					</div>
					<div class="p1_cont p1_cont_p">
						<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
							<s:file id="upload_btn_1" name="upload" />
						</div>
						<s:form action="config!setting_auto_guanzhu_save" namespace="/admin" id="auto_save_guanzhu_from">
							<s:hidden name="auto.contentType" value="2" />
							<input type="hidden" name="auto.mediaId" value="<s:property value="#request.gz_auto.mediaId"/>" />
							<input type="hidden" name="auto.picUrl" value="<s:property value="#request.gz_auto.picUrl"/>" />
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab_1">
								<tbody>
									<tr>
										<td align="right" valign="top">
											回复：
										</td>
										<td>
											<textarea name="auto.content" cols="45" rows="5" class="txta1"><s:property value="#request.gz_auto.content"/></textarea>
											<div style="width: 818px;border: 1px solid #AAA;padding: 5px;display:none" id="upload_div_1">
												<img class="auto_size" src="<s:property value="#request.gz_auto.picUrl" default="#" />" alt=""  id="upload_img_1" />
											</div>
											<div class="opr1">
												<img src="resources/images/opr_img4.png" width="24" height="24" alt="文字消息" onclick="change_type(2,1)" />
												<img src="resources/images/opr_img1.png" width="24" height="24" alt="图片消息" onclick="change_type(1,1)" />
												<!-- 
												<img src="resources/images/opr_img2.png" width="24" height="24" />
												<img src="resources/images/opr_img3.png" width="24" height="24" />
												-->
											</div>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
										<td>
											<input type="submit" value="保存" class="btn_tj btn_w2" />
										</td>
									</tr>
								</tbody>
							</table>
						</s:form>
					</div>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>
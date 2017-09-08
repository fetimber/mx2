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
			.tab1 td{text-align: center; font-family: "Courier New","微软雅黑"}
			#base_frm_project_area-button{height: 30px;margin-left: 15px;}
		</style>
		<script type="text/javascript">
			$(function(){
				$("select").selectmenu({width:"180px"});
			});
			
			function _forward_page(page){
				$("#page_current").val(page);
				$("#base_frm").submit();
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;上线管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check" style="min-width: 850px;">
				<s:form action="agent!superior" namespace="/admin" id="base_frm" style="float:left;">
					<s:textfield name="query.keyword" cssClass="auto_tips" alt="请输入经纪人姓名、手机号码" style="float:left; width:300px;border:1px solid #aaa;height:28px;padding:1px 5px;line-height:28px"></s:textfield>
					<s:hidden name="page.current" id="page_current"></s:hidden>
				</s:form>
				<input type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)" />
			</div>
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1680px">
				<tr>
					<th width="4%">
						序号
					</th>
					<th width="20%">
						经纪人名称
					</th>
					<th width="20%">
						联系方式
					</th>
					<th width="20%">
						工作区域
					</th>
					<th width="20%">
						操作
					</th>
				</tr>
				<s:if test="null != page.beans && page.beans.size()>0">
				<s:iterator value="#request.page.beans" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td>
							<s:property value="%{#request.page.start + #st.count}" />
						</td>
						<td>
							<s:property value="#item.user.realName" />
						</td>
						<td>
							<s:property value="#item.user.phone" />
						</td>
						<td>
							<s:property value="#item.workArea" />
						</td>
						<td>
                             <a href="admin/agent!subordinate?query.signCountMin=<s:property value="#item.id" />">查看下线</a>
						</td>
					</tr>
				</s:iterator>
			    </s:if>
					<s:else>
						<tr>
							<td colspan="5" align="center">
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
	</body>
</html>
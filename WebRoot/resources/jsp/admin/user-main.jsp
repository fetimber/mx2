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
   <base href="<%=basePath %>" />
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link rel="stylesheet" type="text/css" href="resources/css/style.css"></link>
   <script type="text/javascript" src="resources/js/jquery.min.js"></script>
   <script type="text/javascript" src="resources/js/highchart/highcharts.js"></script>
   <script type="text/javascript" src="resources/js/report.js"></script>
   
   <script type="text/javascript">
     var data_array = new Array();
     var xAxis = new Array();
     $(function() {   
		<s:iterator value="info.list" var="item" status="st">
			data_array.push(<s:property value="#item.amount" />);
			xAxis.push('<s:property value="#item.realName" />');
		</s:iterator>

		var pricedata = [{name:'人数',data:data_array}];
		// 图表信息填充
		canvasReport('MainAnalysis','',xAxis,'人数（个）','',pricedata,2);
	  	
		
	 });
   
   function worker(){
      window.location.href = "admin/govworker!view";
   }
   
   function poor(){ 
      var  roleId=  <s:property value="#session.userinfo_in_session.roleId" />;
      //省级
      if("11" == roleId){
         window.location.href = "admin/govworker!view_poor2";
      }else if("12" == roleId){
         window.location.href = "admin/govworker!view_poor1";
      }else{
         window.location.href = "admin/govworker!view_poor";
      }
   }
   
   function honor(){
       var  roleId=  <s:property value="#session.userinfo_in_session.roleId" />;
      //省级
      if("11" == roleId){
         window.location.href = "admin/govhonor!view2";
      }else if("12" == roleId){
         window.location.href = "admin/govhonor!view1";
      }else{
         window.location.href = "admin/govhonor!view";
      }
   }
   
   </script>
</head>

<body>
<div style="padding:20px;">
  <div class="part1" style="margin-top:20px;"> 
    <!--今日报备-->
<!--     <div class="module1" > <img src="resources/images/icon_hyk_1.png" class="bg_img1"/> -->
<!--       <p class="module1_txt1">今日新增职工</p> -->
<!--       <p class="module1_txt_01"><s:property value="info.todayRef"/></p> -->
<!--       <p class="module1_txt3"><span class="module1_txt4">职工总数：</span><span class="module1_txt5"><s:property value="info.refTotal"/>人</span></p> -->
<!--     </div> -->
    <!--今日注册-->
    <div class="module2" onclick="poor();" > <img src="resources/images/icon_hyk_2.png" class="bg_img1"/>
      <p class="module1_txt1">未审核困难职工数</p>
      <p class="module1_txt_01">
      <s:if test = "#session.userinfo_in_session.roleId == 11"> 
        0
      </s:if>
      <s:else>
        <s:property value="info.todayReg"/> 
      </s:else>
      </p>
      <p class="module1_txt3"><span class="module1_txt4">困难职工人数：</span><span class="module1_txt5"><s:property value="info.regTotal"/>人</span></p>
    </div>
    <!--今日结佣-->
    <div class="module3" onclick="honor();" > <img src="resources/images/icon_hyk_4.png" class="bg_img1"/>
      <p class="module1_txt1">未审核荣誉数</p>
       <p class="module1_txt_01">
       <s:if test = "#session.userinfo_in_session.roleId == 11"> 
        0
      </s:if>
       <s:else>
         <s:property value="info.todayBal"/></p>
       </s:else>
      <p class="module1_txt3"><span class="module1_txt4">总荣誉数：</span><span class="module1_txt5"><s:property value="info.balTotal"/>个</span></p>
    </div>
    <div class="clear"></div>
  </div>
  <div class="part2" style="margin-top:40px;">
    <div class="p1_tpc"><img src="resources/images/icon_form.png" width="16" height="16" />&nbsp;&nbsp;职工人数TOP10单位柱图</div>
    <div class="contain_all" style="height:420px;">
      <div id="MainAnalysis" class="contain" style="padding:20px 0;">
         
      </div>
    </div>
  </div>
</div>

</body>
</html>

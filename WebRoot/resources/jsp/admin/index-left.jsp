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
<!--    <link rel="stylesheet" type="text/css" href="resources/css/style.css"></link> -->
   <link rel="stylesheet" type="text/css" href="resources/css/style_login.css"></link>
   <script type="text/javascript" src="resources/js/jquery.min.js"></script>
   <script type="text/javascript">
      var menuList = new Array();
	  var menuTitle = new Array();
	    menuTitle.push({menuTitle:"职工库"});
	    menuTitle.push({menuTitle:"困难职工库"});
	    menuTitle.push({menuTitle:"荣誉职工库"});
	    menuTitle.push({menuTitle:"荣誉单位库"});
	    menuTitle.push({menuTitle:"系统设置"});
      $(function(){
      		<s:if test="menuList != null">
					<s:iterator value="menuList" var="item">
						menuList.push({"menuName":"<s:property value="#item.menuName" />","menuUrl":"<s:property value="#item.menuUrl" />","sortDecimal":"<s:property value="#item.sortDecimal" />"});
					</s:iterator>
			</s:if>
            
            init();
            $(".nav ul").hide();
      		//标题事件
      		$(".nav span").bind("click", function() {
				if("block" == $(this).next("ul").css("display") ){
				  $(this).next("ul").slideUp();
				}else{
				   if($('.nav ul:visible').size() > 0){
				      $(".nav ul:visible").slideUp();
				   }
				   $(this).next("ul").slideDown(); 
				}
		    });
		 
		    //菜单事件
		    $(".nav a").bind("click", function() {
			    $('.nav_now').removeClass("nav_now");
				$(this).parent().addClass("nav_now");
		    });
      
    });
   
   function init(){
        var html =  "";
        for(var i = 0 ; i < menuList.length ; i ++){
          //alert(menuList[i].sortDecimal);
          if( menuList[i].sortDecimal == 1){
             continue;
          }
          
          if(i == 0 || (i > 0 && menuList[i].sortDecimal != menuList[i-1].sortDecimal)){
             html +="<li><span><img src='resources/images/nav_icon2.png' width='20' height='20'/>" + menuTitle[(menuList[i].sortDecimal)-1].menuTitle +"</span><ul>";
          }
         
          html += " <li><a href='" + menuList[i].menuUrl +"' target='viewmain'>" + menuList[i].menuName + "</a></li>";
          
          if(i == menuList.length - 1 || (i < menuList.length - 1 && menuList[i].sortDecimal != menuList[i+1].sortDecimal)){
             html += "</ul></li>";
          }
        }

        $('#ulmenu').html(html);

        //$('#ulmenu').html(html);
//      	  <li id="li2"> 
// 	      <span><img src="resources/images/nav_icon2.png" width="20" height="20" />困难职工库</span>
// 	       <ul>
// 		      <li><a href="do?id=3" target="viewmain">困难职工统计</a></li>
// 		      <li><a href="do?id=13" target="viewmain">困难职工审核</a></li>
// 		      <li><a href="do?id=4" target="viewmain">困难职工管理</a></li>
// 	       </ul>
//        </li>
  

   
   }
   
   </script>
   
</head>
<body class="left">
	<div class="logo"><a href="admin/user!main" target="viewmain" style="color:#FFF;">工会人员数据库</a> </div>
<!-- 	<div class="logo"><a href="admin/user!main" target="viewmain"><img src="resources/images/logo.png" width="160" height="60"/></a> </div> -->
	<ul class="nav" id ="ulmenu">
<!-- 	  <li style="display: none">  -->
<!-- 	     <span><img src="resources/images/nav_icon2.png" width="20" height="20" />会员库</span> -->
<!-- 	      <ul> -->
<!-- 	          <li><a href="do?id=1" target="viewmain">全省会员统计</a></li> -->
<!-- 	          <li><a href="do?id=2" target="viewmain">单位会员管理</a></li> -->
<!-- 	      </ul> -->
<!-- 	  </li> -->
	    
	  <li id="li2"> 
	      <span><img src="resources/images/nav_icon2.png" width="20" height="20" />困难职工库</span>
	       <ul>
	          <li><a href="do?id=4" target="viewmain">困难职工管理</a></li>
	          <li><a href="do?id=13" target="viewmain">困难职工审核</a></li>
		      <li><a href="do?id=3" target="viewmain">困难职工统计</a></li>  
	       </ul>
       </li>
       
       <li id="li3"> 
	      <span><img src="resources/images/nav_icon2.png" width="20" height="20" />荣誉职工库</span>
	       <ul>
		       <li><a href="do?id=5" target="viewmain">获奖情况统计</a></li>
		       <li><a href="do?id=14" target="viewmain">获奖情况审核</a></li>
		       <li><a href="do?id=6" target="viewmain">获奖情况管理</a></li>
	       </ul>
       </li>
       
       <li id="li4"> 
	      <span><img src="resources/images/nav_icon2.png" width="20" height="20" />荣誉单位库</span>
	       <ul>
		       <li><a href="do?id=17" target="viewmain">单位荣誉统计</a></li>
		       <li><a href="do?id=16" target="viewmain">单位荣誉审核</a></li>
		       <li><a href="do?id=15" target="viewmain">单位荣誉管理</a></li>
	       </ul>
       </li>
       
       <li>
	     <span><img src="resources/images/nav_icon3.png" width="20" height="20" />系统设置</span>
	      <ul>
	          <li><a href="do?id=7" target="viewmain">单位管理</a></li>
	          <li><a href="do?id=8" target="viewmain">用户管理</a></li>
		      <li><a href="do?id=9" target="viewmain">权限管理</a></li>
		      <li><a href="do?id=10" target="viewmain">个人设置</a></li>
	      </ul>
	  </li>
	 </ul>
</body>


</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="Pagination" class="pagination"></div>
<link rel="stylesheet" type="text/css" href="resources/css/page.css"></link>
<script type="text/javascript" src="resources/js/jquery.page.js"></script>
<script type="text/javascript">
	$("#Pagination").pagination(<s:property value="page.count" />, {
		items_per_page: <s:property value="page.offset" />, //偏移量
		current_page:<s:property value="%{page.current - 1}" />,
		num_edge_entries: 5,
		prev_show_always:true,
		next_show_always:true,
		ellipse_text:'...',
		prev_text:'上一页',
		next_text:'下一页',
		link_to:'javascript:_forward_page(__id__)'
	});
</script>
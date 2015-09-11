<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/JTMS/core/ext-4.2/resources/css/ext-all-neptune.css"/>
<script type="text/javascript" src="/JTMS/core/ext-4.2/bootstrap.js"></script>
<script type="text/javascript" src="/JTMS/core/ext-4.2/locale/ext-lang-zh_CN.js"></script>
<script src="/JTMS/core/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var form = $("form#extForm");
		var btn1 = $("input#btn1");
		var btn2 = $("input#btn2");
		var btn3 = $("input#btn3");
		btn1.click(function(){
			$("input#url").val(btn1.attr("name"));
			form.submit();
		});
		btn2.click(function(){
			$("input#url").val(btn2.attr("name"));
			form.attr("action", "/JTMS/lesson/gridmvc/get");
			form.submit();
		});
		btn3.click(function(){
			$("input#url").val(btn3.attr("name"));
			form.attr("action", "/JTMS/lesson/treemvc/tree")
			form.submit();
		});
	});
</script>
</head>
<body>


参数：${result}

<form action="#" method="post" id="extForm">
	<img height="25" width="100" src="../image/exit.png">
	<div class="exit"></div>
	<input type="button" value="grid" id="btn1" name="/lesson/grid01/grid" />
	<input type="button" value="grid-mvc" id="btn2" name="/lesson/gridmvc/grid_mvc" />
	<input type="button" value="tree-mvc" id="btn3" name="/lesson/treemvc/tree_mvc" />
	<input type="hidden" value="" id="url" name="url" />
</form>



</body>
</html>
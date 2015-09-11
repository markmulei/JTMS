<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="java.net.InetAddress"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>  
    <div style="height:60px;padding: 30px">
    	<div  style="position: absolute; left: 45px; top: 30px">
    		JTMS
    	</div>
    	<center id="showTime" style="vertical-align: top;"></center>
    	<div style="position: absolute;left: 500px; bottom: 8px;">
    		<font size=2px><strong><font color=blue>admin</font></strong>，欢迎您进入JTMS
    		<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录IP:&nbsp;<font color=green><%= request.getRemoteHost() %></font></strong></font>
    	</div>
    </div>  
</body>
</html>

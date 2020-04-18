<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发送短信</title>
    <script src="<%=basePath %>/static/js/jquery-1.8.2.min.js"></script>
</head>
<body>
    手机号：<input type="text">
    <button id="sendSMS">发送短信验证码</button>
</body>
</html>

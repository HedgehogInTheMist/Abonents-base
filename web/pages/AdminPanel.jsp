<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Hello there, Administrator!</h1>
	<p>Hello there, <c:out value="${abonent.firstName}"/> </p>
		${ abonent.role }, hello to you!
		
		
		<h1>Hello there, abonent <c:out value="${abonent.firstName}"/> <c:out value="${abonent.secondName}!"/></h1>
	<a href="./Controller?command=Logout">Logout</a>
	
</body>
</html>
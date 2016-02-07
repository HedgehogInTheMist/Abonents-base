<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	Request from ${ pageContext.errorData.requestURI } is failed
	<br/>
	Servlet name or type: ${ pageContext.errorData.servletName }
	<br/>
	Status code: ${ pageContext.errorData.statusCode }
	<br/>
	Exception: ${ pageContext.errorData.throwable }
	<br/>
</body>
</html>
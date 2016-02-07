<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome</title>
</head>
<body>
	<h3>Welcome</h3>
	<hr/>
		${ user }, hello to you! 
	<hr/>
	<a href="Controller?command=Logout">Logout</a>
	
	<p>Проверка работы системы команд[<a href="Controller?command=Enter">посмотреть</a>]</p><br>
	
	
</body>
</html>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" method="post" action="Controller">
		<input type="hidden" name="command" value="login"/>
		
		Login:<br/>
		<input type="text" name="login" value=""/>
		<br/>Password:<br/>
		<input type="password" name="password" value=""/>
		<br/>
			${ errorLoginPassMessage }
		<br/>
			${ wrongAction }
		<br/>
			${ nullPage }
		<br/>
		<input type="submit" value="Log in"/>
		
		<p>Проверка работы системы команд[<a href="Controller?command=enter">Посмотреть Другую страничку ввода пароля</a>]</p><br>
		
	</form><hr/>
</body>
</html>
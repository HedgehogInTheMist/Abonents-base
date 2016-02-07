<%@page pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>Система "Телефонная станция"</title>
</head>
<body>
	<div id="register">
		<form name="loginForm" method="post" action="Controller" accept-charset="UTF-8">
		<input type="hidden" name="command" value="login"/>
			
			<fieldset class="clearfix">
		<h2 align="center">Введите логин и пароль для доступа</h2>
				<p align="center">
					Введите логин <br>
					<input type="text" name="login" value=""/>
				</p>
				<p align="center">
					Введите пароль<br>
					<input type="password" name="password" value=""/>
				</p>
				<p align="center">
				
					<input type="submit" name="enter" value="Вход">
				</p>
			</fieldset>
		</form>
		<p align="center">Нет аккаунта?</p>

		<p align="center">
			<a href="pages/registration.jsp" name="registration">Регистрация</a>
			&nbsp;&nbsp;или&nbsp;&nbsp; <a href="pages/servicesList.jsp"
				name="page">Список услуг</a>
		</p>

	</div>




</body>
</html>

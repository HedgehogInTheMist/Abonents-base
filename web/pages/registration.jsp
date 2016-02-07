<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Факультатив Регистрация</title>
</head>
<body>

	<div id="register">
		<form action="/AbonentCabinet" method="post" accept-charset="UTF-8">
			<input type="hidden" name="page" value="add_person">
				<fieldset class="clearfix">
					<p align="center">
						Введите имя<br><input type="text" name="firstName">
					</p>
					<p align="center">
						Введите фамилию<br><input type="text" name="secondName">
					</p>

					<p align="center">
						Введите логин<br><input type="text" name="login">
					</p>
					<p align="center">
						Введите пароль<br><input type="password" name="password">
					</p>

					<p align="center">
						Введите e-mail<br><input type="text" name="email">
					</p>
					<input type="hidden" name="role" value="abonent"></p>
						<p align="center">
							<input type="submit" name="register">
						</p>
				</fieldset>
		</form>
		<p align="center">Нет аккаунта?</p>

		<p align="center">
			<a href="serviceslist.jsp">Список услуг</a>
		</p>
	</div>

</body>
</html>

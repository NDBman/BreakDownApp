<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreakDown App</title>
</head>
<body>
	<form  action="login" method="post">
	<label for="bboyname">Felhasználónév(BBoy/Girl név):</label>
	<input id="bboyname" type="text" name="bboyname"/>
	<label for="password">Jelszó:</label>
	<input id="password" type="password" name="password"/>
	<input type="submit" value="Belépés">
	</form>
</body>
</html>
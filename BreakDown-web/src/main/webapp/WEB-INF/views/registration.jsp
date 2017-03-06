<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreakDownApp</title>
</head>
<body>
	<form action="newBreaker" method="POST">
		<label for="username">Név:</label>
		<input id="username" type="text" name="username"> 
		<label for="password">Jelszó:</label>
		<input id="password" type="password" name="password"> 
		<input type="submit" value="Küldés">
	</form>
	<br>
	<form action="back" method="POST">
		<button>Vissza</button>
	</form>
</body>
</html>
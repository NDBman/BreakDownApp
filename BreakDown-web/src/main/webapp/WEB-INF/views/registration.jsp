<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreakDownApp</title>
</head>
<body>
	<form action="registration" method="POST">
	
		<label for="name">Név:</label> 
		<input id="name" type="text" name="name"><br /> 
		
		<label>BBoy/Girl név:</label> 
		<input id="bname" type="text" name="bname" /><br />
		
		<label for="password">Jelszó:</label>
		<input id="password" type="password" name="password" /><br /> 
		<label for="password_again">Jelszó ismét:</label>
		<input id="password_again" type="password" name="password_again"><br />
		
		<label for="gender">Nem:</label> 
		<select id="gender" name="gender">
			<option value="1">Férfi</option>
			<option value="2">Nő</option>
		</select><br>
		<label for="birthday">Születési idő:</label>
		<input id="birthday" type="date" name="birthday"/>
		<input type="submit" value="Küldés" />
	</form>
	<br>
</body>
</html>
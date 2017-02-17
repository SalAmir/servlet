<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Configuration</title>
</head>
<body>
	<form action="SecondaryServlet" method="post" name="r_form">
		<p>
			<label for="firstname">Name: </label> <input type="text"
				id="firstname" name="firstname" />
		</p>
		<p>
			<label for="lastname">Surname: </label> <input type="text"
				id="lastname" name="lastname" />
		</p>
		<p>
			<label for="city">City: </label> <input type="text" id="city"
				name="city" />
		</p>
		<p>
			<label for="date">Birthday: </label> <input type="date" id="date"
				name="date" />
		</p>
		<p>
			<button type="submit">Ok</button>
		</p>
	</form>
</body>
</html>
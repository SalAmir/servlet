<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registry page</title>
</head>
<head><body>
	<p align="center">
		<img src="images/googlelog.png" width="135" height="40" />
	</p>
	<%@ include file="index.jsp"%> <br>
</body>
</head>
<html>
<center>
	<body>
		<h2>Please submit your information</h2>
		<form method="post" action="SecondaryServlet">
			<table border=0>
				<tr>
					<td valign=top>Your first name:</td>
					<td valign=top><input type=text name=firstname size=20>
					</td>
				</tr>
				<tr>
					<td valign=top>Your last name:</td>
					<td valign=top><input type=text name=lastname size=20>
					</td>
				</tr>
				<tr>
					<td valign=top>Your email:</td>
					<td valign=top><input type=text name=email size=20></td>
				</tr>
				<tr>
					<td valign=top><input type=submit value=Submit Info></td>
				</tr>
			</table>
		</form>
	</body>
</center>
</html>
<body>
</body>
</html>
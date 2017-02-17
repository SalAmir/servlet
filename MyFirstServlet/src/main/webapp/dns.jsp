<%@page import="java.io.PrintWriter"%>
<%@page import="java.awt.event.ActionListener"%>
<%@page import="javax.swing.Timer"%>
<%@page import="java.util.TimerTask"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<body>
	<div class="parent">
		<div class="block">
			<p align="center">
				<img src="images/googlelog.png" alt="" />
			</p>
		</div>
	</div>
</body>
</head>

<center>
	<fieldset style="width:270px">
		<form action="SecondaryServlet" method="post" name="r_form">
			<table>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" required="required" autocomplete="off" />
					</td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required" autocomplete="off" /></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2"><input type="submit"
						name="r_send" value="Sign in" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
</center>


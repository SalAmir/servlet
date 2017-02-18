package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connection;
import database.Settings;
import model.AccountModel;
import model.Model;

public class SecondaryServlet extends HttpServlet{
	
	private Model model = new Model();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		List<AccountModel> users = model.getListAccounts();
		Enumeration paramNames = req.getParameterNames();
		String parName;
		
		
		boolean emptyEnum = false;
		
		if (!paramNames.hasMoreElements()){
			emptyEnum = true;
		}
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		 
		out.println("<html><head>");
		out.println("<title> Submitted Parameters </title></head><body>");
		
		if (emptyEnum){
			out.println(
					"<h2>Sorry, the request does not contain any parameters</h2>");
		}else{
			out.println("<h2> Here are the submitted parameter values</h2>");
		}
		
		
		boolean hasExist = false;
		String login = null;
		String password = null;
		while(paramNames.hasMoreElements()){
			parName = paramNames.nextElement().toString();
			if (parName.equals("login")){
				login = req.getParameter(parName);
			}
			else if (parName.equals("password")){
				password = req.getParameter(parName);
			}
		}
		System.out.println(login + "    "  + password);
		boolean p = false;
		System.out.println(users);
		if(users != null){
			for(AccountModel user : users){
				System.out.println(user.getLogin() + "cc" + user.getPassword());
				if (user.getLogin().equals(login) && user.getPassword().equals(password)){
					hasExist = true;
				}
				else if (user.getLogin().equals(login) && !user.getPassword().equals(password))
				{
					p = true;
				}
			}
		}
		
		if (hasExist){
			RequestDispatcher reqDispatcher = req.getRequestDispatcher("test.jsp");
			reqDispatcher.forward(req, resp);
		}
		else
		{
			//RequestDispatcher reqDispatcher = req.getRequestDispatcher("registry2.jsp");
			//reqDispatcher.forward(req, resp);
			if (p){
				out.println(
					"<h2>Login using!!!</h2>");
			}
			else{
//				String name = req.getParameter("login");
//				Cookie cookie = new Cookie("login", login);
//				cookie.setMaxAge(30*60);
//				resp.addCookie(cookie);
				Settings settings = new Settings("", "", "", Date.valueOf(LocalDate.now()));
				model.entityFilling(login, password, settings);
			}
		}
	}
}

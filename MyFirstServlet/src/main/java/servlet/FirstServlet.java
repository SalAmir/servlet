package servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.hibernate.cfg.AnnotationConfiguration;

import connection.Connection;
import model.Model;

public class FirstServlet extends HttpServlet{

	//private Connection conn = Connection.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

//		RequestDispatcher reqDispatcher = req.getRequestDispatcher("test.jsp");
//		reqDispatcher.forward(req, resp);
		
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("dns.jsp");
		reqDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//		List<Model> users = conn.getUsers();
		//		Enumeration paramNames = req.getParameterNames();
		//		String parName;
		//		
		//		boolean emptyEnum = false;
		//		
		//		if (!paramNames.hasMoreElements()){
		//			emptyEnum = true;
		//		}
		//		resp.setContentType("text/html");
		//		
		//		PrintWriter out = resp.getWriter();
		//		 
		//		out.println("<html><head>");
		//		out.println("<title> Submitted Parameters </title></head><body>");
		//		
		//		if (emptyEnum){
		//			out.println(
		//					"<h2>Sorry, the request does not contain any parameters</h2>");
		//		}else{
		//			out.println("<h2> Here are the submitted parameter values</h2>");
		//		}
		//		 
		//		String email = null;
		//		String firstName = null;
		//		String lastName = null;
		//		while(paramNames.hasMoreElements()){
		//			parName = paramNames.nextElement().toString();
		//			if (parName.equals("firstname"))
		//				firstName = req.getParameter(parName);
		//			else if (parName.equals("lastname"))
		//				lastName = req.getParameter(parName);
		//			else if (parName.equals("email"))
		//				email = req.getParameter(parName);
		////			parName = paramNames.nextElement().toString();
		////			
		////			out.println(
		////					"<strong>" + parName + "</strong> :" +
		////			req.getParameter(parName));
		////			
		////			out.println("<br/>");
		//		}
		//		
		//		
		//		conn.addAccounts(email, firstName, lastName);
		//		out.println("</body></html>");
	}


}

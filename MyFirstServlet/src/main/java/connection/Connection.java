package connection;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import database.Accounts;
import database.Settings;
import hibernate.HibernateUtil;
import model.Model;

public class Connection {

	private static volatile Connection uniqueInstance;
	private static Session session = null;
	
	public static Connection getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new Connection();
		}
		return uniqueInstance;
	}
	
	public Session getSession(){
		return session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void sessionClose(){
		session.close();
		HibernateUtil.shutdown();
	}
	private Connection(){
		getSession().connection();
	}
}

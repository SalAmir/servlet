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
	private List<Accounts> listAccounts = null;
	
	public static Connection getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new Connection();
			getSession().connection();
		}
		return uniqueInstance;
	}
	
	private void getAccounts(){
		try{
			session.beginTransaction();
			Query query = session.createQuery("FROM Accounts");
			listAccounts = query.list();
			session.getTransaction().commit();
		}
		catch (HibernateException he){
			he.printStackTrace();
		}
		catch (RuntimeException runEx){
			runEx.printStackTrace();
		}
	}
	
	public void addAccounts(String login, String password){
		try{
			session.beginTransaction();
			Date date = Date.valueOf(LocalDate.now());
			Accounts acc = new Accounts();
			Settings settings = new Settings();
			acc.setLogin(login);
			acc.setPassword(password);
			session.persist(settings);
			acc.setConfigId(settings);
			session.persist(acc);
			//session.save(acc);
			session.getTransaction().commit();
			acc = null;
		}
		catch (HibernateException he){
			he.printStackTrace();
		}
		catch (RuntimeException runEx){
			runEx.printStackTrace();
		}
	}
	
	public LinkedList<Model> getUsers(){
		getAccounts();
		LinkedList<Model> listUsers = new LinkedList<Model>();
		if (listAccounts != null){
			for (Accounts acc : listAccounts){
				int id = acc.getID();
				String login = acc.getLogin();
				String password = acc.getPassword();
				listUsers.add(new Model(id, login, password));
			}
			return listUsers;
		}
		return null;
	}
	
	private static Session getSession(){
		return session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void sessionClose(){
		session.close();
		HibernateUtil.shutdown();
	}
	private Connection(){}
}

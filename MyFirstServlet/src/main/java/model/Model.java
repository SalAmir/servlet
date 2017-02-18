package model;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import connection.Connection;
import database.Accounts;
import database.Settings;
import hibernate.HibernateUtil;

public class Model {

	private Connection conn = Connection.getInstance();
	private Session session = conn.getSession();
	
	public List<AccountModel> getListAccounts(){
		try{
			List<AccountModel> accModels = null;
			List<Accounts> accounts = null;
			session.beginTransaction();
			Query query = session.createQuery("FROM Accounts");
			accounts = query.list();
			session.getTransaction();
			if(accounts != null){
				for (Accounts acc : accounts){
					System.out.println(acc);
					AccountModel accountModel = new AccountModel();
					accountModel.setId(acc.getID());
					accountModel.setLogin(acc.getLogin());
					accountModel.setPassword(acc.getPassword());
					accountModel.getConfiguration().setId(acc.getConfiguration().getId());
					accountModel.getConfiguration().setFirstName(acc.getConfiguration().getFirstName());
					accountModel.getConfiguration().setLastName(acc.getConfiguration().getLastName());
					accountModel.getConfiguration().setCity(acc.getConfiguration().getCity());
					accountModel.getConfiguration().setBirthday(acc.getConfiguration().getBirthday());
					accModels.add(accountModel);
				}
				return accModels;
			}
		}
		catch (HibernateException he){
			he.printStackTrace();
		}
		catch (RuntimeException runExcep){
			runExcep.printStackTrace();
		}
		
		return null;
	}
	
	public void entityFilling(String login, String password, Settings settings){
		try{
			session.beginTransaction();
			Accounts acc = new Accounts();
			acc.setLogin(login);
			acc.setPassword(password);
			session.persist(settings);
			acc.setConfiguration(settings);
			session.persist(acc);
			session.getTransaction().commit();
			acc = null;
		}
		catch (HibernateException he){
			he.printStackTrace();
		}
		catch (RuntimeException runExcep){
			runExcep.printStackTrace();
		}
	}
}

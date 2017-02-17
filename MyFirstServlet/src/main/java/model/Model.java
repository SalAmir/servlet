package model;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateUtil;

public class Model {

	private int id = 0;
	private String login = null;
	private String password = null;
	
	public int getId(){
		return id;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	
	public Model(int id, String login, String password){
		this.id = id;
		this.login = login;
		this.password = password;
	}
}

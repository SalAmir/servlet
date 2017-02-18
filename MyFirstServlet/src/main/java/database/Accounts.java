package database;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACCOUNTS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ACCOUNTS_ID"),
		@UniqueConstraint(columnNames = "LOGIN") })
public class Accounts implements Serializable{
	private static final long serialVersionUID = -1662632145678182481L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNTS_ID", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "CONFIGURATION_ID")
	private Settings config;
	
	@Column(name = "LOGIN", unique = true, nullable = false, length = 100)
	private String login;
	
	@Column(name = "PASSWORD", unique = false, nullable = false, length = 100)
	private String password;

	public Integer getID(){
		return id;
	}

	public Settings getConfiguration(){
		return config;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setConfiguration(Settings config){
		this.config = config;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	@Override
    public String toString(){
    	return "Accounts [id=" + id + ", login=" + login + ", password=" + password + ", settings=" + config + "]";
    }
}

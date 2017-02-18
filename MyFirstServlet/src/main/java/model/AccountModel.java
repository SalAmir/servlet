package model;

public class AccountModel {
	
	private int id = 0;
	private String login = null;
	private String password = null;
	private SettingModel settings = null;
	
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public SettingModel getConfiguration(){
		return settings;
	}
	
	public void setConfiguration(SettingModel settings){
		this.settings = settings;
	}
}

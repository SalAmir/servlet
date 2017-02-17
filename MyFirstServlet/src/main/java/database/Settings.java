package database;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "SETTINGS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CONFIGURATION_ID")
})
public class Settings implements Serializable{

	private static final long serialVersionUID = 1529089957228828802L;

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONFIGURATION_ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME", unique = false, nullable = true)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = true)
	private String lastName;
	
	@Column(name = "CITY", unique = false, nullable = true)
	private String city;
	
	@Column(name = "BIRTHDAY", unique = false, nullable = true)
	private Date birthday;
	
	public long getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
    
    public Date getBirthday() {
        return birthday;
    }
 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public Settings(){}
    
    public Settings(String firstName, String lastName, String city, Date birthday){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.city = city;
    	this.birthday = birthday;
    }
}

package task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tckn") 
	private String tckn;
	
	@Column(name="name") 
	private String name;
	
	@Column(name="surname") 
	private String surname;

	@Column(name="email") 
	private String email;

	@Column(name="gender") 
	private boolean gender;
	
	@Column(name="statuid") 
	private boolean statuid;
	
	public String getTckn() {
		return tckn;
	}

	public String getEmail() {
		return email;
	}

	public boolean isGender() {
		return gender;
	}

	public boolean isStatuid() {
		return statuid;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Customer(String tckn, String name, String surname, String email, boolean gender, boolean statuid) {
		this.tckn = tckn;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
		this.statuid = statuid;
	}

	public void setStatuid(boolean statuid) {
		this.statuid = statuid;
	}

	public int getId() {
		return this.id;
	}

}


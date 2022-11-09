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

	public String getTckn() {
		return tckn;
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

	public Customer() {}
	
	public Customer(String tckn, String name, String surname) {
		this.tckn = tckn;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return this.id;
	}

}


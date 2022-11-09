package net.jtask.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "phone" )
public class Phone {

	@Id
	@GeneratedValue
	private int ID ;
    private String Phone1;
    private String Phone2;
	
	public String getPhone1() {
		return Phone1;
	}
	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}
	public String getPhone2() {
		return Phone2;
	}
	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
    
	public Phone(int id, String phone1, String phone2) {
		super();
		ID = id;
		Phone1 = phone1;
		Phone2 = phone2;
	}
   
}

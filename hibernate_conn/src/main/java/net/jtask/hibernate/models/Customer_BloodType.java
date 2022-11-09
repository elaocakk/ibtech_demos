package net.jtask.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "customer_bloodtype" ) 
public class Customer_BloodType {

	@Id
	@GeneratedValue
	private int ID ;
	private String TypeName;

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Customer_BloodType(int id, String typeName) {
		super();
		ID = id;
		TypeName = typeName;
	}

    
	
    
    
}

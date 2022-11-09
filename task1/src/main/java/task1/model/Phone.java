package task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="customerid") 
	private int customerid;
	
	@Column(name="phone") 
	private String phone;	
	
	public Phone() {}
	
	public Phone(int customerid, String phone) {
		super();
		this.customerid = customerid;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerid;
	}

	public int getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}

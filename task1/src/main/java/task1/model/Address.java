package task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	@Column(name="customerid") 
	private int customerid;
	
	@Column(name="address") 
	private String address;
	
	@Column(name="buildno") 
	private String buildno;
	
	@Column(name="apartno") 
	private String apartno;

	@Column(name="city") 
	private String city;

	public int getId() {
		return this.id;
	}

	public Address() { }
	
	public Address(int customerid, String address, String buildno, String apartno, String city ) {
		this.customerid = customerid;
		this.address = address;
		this.buildno = buildno;
		this.apartno = apartno;
		this.city = city;
	}

	public int getCustomerId() {
		return customerid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuildno() {
		return buildno;
	}

	public void setBuildno(String buildno) {
		this.buildno = buildno;
	}

	public String getApartno() {
		return apartno;
	}

	public void setApartno(String apartno) {
		this.apartno = apartno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

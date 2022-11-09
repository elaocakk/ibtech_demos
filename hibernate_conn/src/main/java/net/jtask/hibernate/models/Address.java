package net.jtask.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	private int ID ;
    private String Address;
    private String BuildNo;
    private String ApartNo;
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getBuildNo() {
		return BuildNo;
	}
	public void setBuildNo(String buildNo) {
		BuildNo = buildNo;
	}
	public String getApartNo() {
		return ApartNo;
	}
	public void setApartNo(String apartNo) {
		ApartNo = apartNo;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
   
	public Address(int id,String address, String buildNo, String apartNo) {
		super();
		ID = id;
		Address = address;
		BuildNo = buildNo;
		ApartNo = apartNo;
	}
    
	
    
    
}

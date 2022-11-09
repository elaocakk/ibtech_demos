package net.jtask.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer" )
public class Customer {

	@Id
	@GeneratedValue
	private int ID;
	private String TCKN;
    private String Name;
    private String Surname;
    private String BirthdayDate;
    private String EMail;
    private boolean Gender;
    private int BloodTypeID;
    private boolean StatuID;
    
    private Account account;
    private Address address;
    private Customer_BloodType customer_BloodType;
    private Phone phone;
    
	public String getTCKN() {
		return TCKN;
	}
	public void setTCKN(String tCKN) {
		TCKN = tCKN;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getBirthdayDate() {
		return BirthdayDate;
	}
	public void setBirthdayDate(String birthdayDate) {
		BirthdayDate = birthdayDate;
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public boolean isGender() {
		return Gender;
	}
	public void setGender(boolean gender) {
		Gender = gender;
	}
	public int isBloodTypeID() {
		return BloodTypeID;
	}
	public void setBloodTypeID(int bloodTypeID) {
		BloodTypeID = bloodTypeID;
	}
	public boolean isStatuID() {
		return StatuID;
	}
	public void setStatuID(boolean statuID) {
		StatuID = statuID;
	}	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer_BloodType getCustomer_BloodType() {
		return customer_BloodType;
	}
	public void setCustomer_BloodType(Customer_BloodType customer_BloodType) {
		this.customer_BloodType = customer_BloodType;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public Customer(int id, String tCKN, String name, String surname, String birthdayDate, String eMail, boolean gender,
			int bloodTypeID, boolean statuID, Account account, Address address, Customer_BloodType customer_BloodType,
			Phone phone) {
		super();
		ID = id;
		TCKN = tCKN;
		Name = name;
		Surname = surname;
		BirthdayDate = birthdayDate;
		EMail = eMail;
		Gender = gender;
		BloodTypeID = bloodTypeID;
		StatuID = statuID;
		this.account = account;
		this.address = address;
		this.customer_BloodType = customer_BloodType;
		this.phone = phone;
	}
    
	public Customer() {
		super();		
	}
	
    
}

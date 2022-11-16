package thread_task.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;

	@Column(name="customerid") 
	private int customerid;
	
	@Column(name="accountnumber") 
	private String accountnumber;
	
	@Column(name="balance") 
	private int balance;
	
	public Account() { }
	
	public Account(int customerid, String accountnumber, int balance) {
		super();
		this.customerid = customerid;
		this.accountnumber = accountnumber;
		this.balance = balance;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getAccountNumber() {
		return accountnumber;
	}

	public void setAccountNumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}	
	
	public int getId() {
		return id;
	}
	
	public int getCustomerId() {
		return customerid;
	}
	
}
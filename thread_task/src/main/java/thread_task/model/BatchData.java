package thread_task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batch_data")
public class BatchData {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;	
	
	@Column(name="sirano") 
	private int sirano;

	@Column(name="status") 
	private boolean status;
	
	@Column(name="accountno") 
	private int accountno;
	
	@Column(name="transactiontype") 
	private char transactiontype;
	
	@Column(name="amount") 
	private int amount;

	public BatchData() {
	
	}
	
	public BatchData(int sirano, boolean status, int accountno, char transactiontype, int amount) {
		this.sirano = sirano;
		this.status = status;
		this.accountno = accountno;
		this.transactiontype = transactiontype;
		this.amount = amount;
	}

	public int getID() {
		return id;
	}

	
	public int getSirano() {
		return sirano;
	}

	public void setSirano(int sirano) {
		this.sirano = sirano;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public char getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(char transactiontype) {
		this.transactiontype = transactiontype;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}

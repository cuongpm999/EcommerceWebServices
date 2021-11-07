package vn.ptit.entities.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CustomerMember")
@PrimaryKeyJoinColumn(name="CustomerID")
public class CustomerMember extends Customer{
	@Column(name = "Point", nullable = false)
	private double point;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customerMember", fetch = FetchType.EAGER)
	private Account account;
	
	public void addAccount(Account account) {
		this.account = account;
		account.setCustomerMember(this);
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}

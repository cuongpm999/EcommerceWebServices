package vn.ptit.entities.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerMember")
@PrimaryKeyJoinColumn(name="CustomerID")
public class CustomerMember extends Customer{
	@Column(name = "Point", nullable = false)
	private double point;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customerMember", fetch = FetchType.EAGER)
	private Account account;

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

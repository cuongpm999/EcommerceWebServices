package vn.ptit.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "Username", nullable = false, length = 255)
	private String username;
	@Column(name = "Password", nullable = false, length = 255)
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerMemberID")
	private CustomerMember customerMember;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerMember getCustomerMember() {
		return customerMember;
	}

	public void setCustomerMember(CustomerMember customerMember) {
		this.customerMember = customerMember;
	}
	
	
}

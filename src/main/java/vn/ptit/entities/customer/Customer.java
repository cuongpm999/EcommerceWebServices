package vn.ptit.entities.customer;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Sex", length = 255)
	private String sex;
	@Column(name = "Mobile", length = 255)
	private String mobile;
	@Column(name = "DateOfBirth")
	private Date dateOfBirth;
	@Column(name = "Email", length = 255)
	private String email;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
	private FullName fullName;
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
	private Address address;
	
	public void addAddress(Address address) {
		this.address = address;
		address.setCustomer(this);
	}
	
	public void addFullName(FullName fullName) {
		this.fullName = fullName;
		fullName.setCustomer(this);
	}
	
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

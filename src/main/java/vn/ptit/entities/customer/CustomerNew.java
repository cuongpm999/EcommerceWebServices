package vn.ptit.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerNew")
@PrimaryKeyJoinColumn(name="CustomerID")
public class CustomerNew extends Customer{
	@Column(name = "Note", length = 255)
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}

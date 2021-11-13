package vn.ptit.entities.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Credit")
@PrimaryKeyJoinColumn(name = "PaymentID")
public class Credit extends Payment {
	@Column(name = "Number", nullable = false, length = 255)
	private String number;
	@Column(name = "Type", nullable = false, length = 255)
	private String type;
	@Column(name = "Date", nullable = false, length = 255)
	private String date;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

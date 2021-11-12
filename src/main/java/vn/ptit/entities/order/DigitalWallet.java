package vn.ptit.entities.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DigitalWallet")
@PrimaryKeyJoinColumn(name = "PaymentID")
public class DigitalWallet extends Payment {
	@Column(name = "Name", nullable = false, length = 255)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

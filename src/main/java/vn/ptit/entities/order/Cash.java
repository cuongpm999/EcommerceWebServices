package vn.ptit.entities.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Cash")
@PrimaryKeyJoinColumn(name="PaymentID")
public class Cash extends Payment{
	@Column(name = "CashTendered", nullable = false)
	private double cashTendered;

	public double getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(double cashTendered) {
		this.cashTendered = cashTendered;
	}
	
}

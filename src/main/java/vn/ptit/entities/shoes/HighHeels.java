package vn.ptit.entities.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "HighHeels")
@PrimaryKeyJoinColumn(name = "ShoesID")
public class HighHeels extends Shoes{
	@Column(name = "Height", nullable = false)
	private double height;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}

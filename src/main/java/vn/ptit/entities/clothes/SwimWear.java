package vn.ptit.entities.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SwimWear")
@PrimaryKeyJoinColumn(name="ClothesID")
public class SwimWear extends Clothes{
	@Column(name = "BustSize", nullable = false)
	private int bustSize;
	
	@Column(name = "WaistSize", nullable = false)
	private int waistSize;
	
	@Column(name = "HipsSize", nullable = false)
	private int hipsSize;

	public int getBustSize() {
		return bustSize;
	}

	public void setBustSize(int bustSize) {
		this.bustSize = bustSize;
	}

	public int getWaistSize() {
		return waistSize;
	}

	public void setWaistSize(int waistSize) {
		this.waistSize = waistSize;
	}

	public int getHipsSize() {
		return hipsSize;
	}

	public void setHipsSize(int hipsSize) {
		this.hipsSize = hipsSize;
	}
	
	
}

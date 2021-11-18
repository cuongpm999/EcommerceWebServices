package vn.ptit.entities.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Boots")
@PrimaryKeyJoinColumn(name = "ShoesID")
public class Boots extends Shoes{
	@Column(name = "IsShoelace", nullable = false)
	private boolean isShoelace;

	public boolean isIsShoelace() {
		return isShoelace;
	}

	public void setShoelace(boolean isShoelace) {
		this.isShoelace = isShoelace;
	}
	
	
}

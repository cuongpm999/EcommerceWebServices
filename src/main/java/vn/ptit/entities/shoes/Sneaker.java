package vn.ptit.entities.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Sneaker")
@PrimaryKeyJoinColumn(name = "ShoesID")
public class Sneaker extends Shoes {
	@Column(name = "Clinch", nullable = false)
	private boolean clinch;
	@Column(name = "Sole", nullable = false, length = 255)
	private String sole;

	public boolean isClinch() {
		return clinch;
	}

	public void setClinch(boolean clinch) {
		this.clinch = clinch;
	}

	public String getSole() {
		return sole;
	}

	public void setSole(String sole) {
		this.sole = sole;
	}

}

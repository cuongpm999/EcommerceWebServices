package vn.ptit.entities.electronics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Laptop")
@PrimaryKeyJoinColumn(name="ElectronicsID")
public class Laptop extends Electronics{
	@Column(name = "Ram", nullable = false, length = 255)
	private String ram;
	@Column(name = "Cpu", nullable = false, length = 255)
	private String cpu;
	@Column(name = "Card", nullable = false, length = 255)
	private String card;

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
}

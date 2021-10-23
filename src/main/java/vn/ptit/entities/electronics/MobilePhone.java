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
@Table(name="MobilePhone")
@PrimaryKeyJoinColumn(name="ElectronicsID")
public class MobilePhone extends Electronics{
	@Column(name = "Ram", nullable = false, length = 255)
	private String ram;
	@Column(name = "Cpu", nullable = false, length = 255)
	private String cpu;
	@Column(name = "Camera", nullable = false)
	private double camera;

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

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}
	
}

package vn.ptit.entities.electronics;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Electronics")
@Inheritance(strategy = InheritanceType.JOINED)
public class Electronics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name", nullable = false, length = 500)
	private String name;
	
	@Column(name = "specifications", nullable = false, columnDefinition = "text")
	private String specifications;
	
	@Column(name = "Warranty", nullable = false)
	private int warranty;
	
	@Column(name = "ScreendSize", nullable = false)
	private double screendSize;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ManufacturerID")
	private Manufacturer manufacturer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public double getScreendSize() {
		return screendSize;
	}

	public void setScreendSize(double screendSize) {
		this.screendSize = screendSize;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}

package vn.ptit.entities.electronics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ElectronicsItem")
public class ElectronicsItem {
	@Id
	@Column(name = "BarCode", length = 255)
	private String barCode;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Discount")
	private double discount;
	
	@Column(name = "Slug", nullable = false, length = 1000)
	private String slug;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ElectronicsID")
	private Electronics electronics;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "electronicsItem", fetch = FetchType.LAZY)
	private List<ImgElectronicsItem> imgElectronicsItems = new ArrayList<>();
	
	public void addImgElectronicsItem(ImgElectronicsItem imgElectronicsItem) {
		imgElectronicsItems.add(imgElectronicsItem);
		imgElectronicsItem.setElectronicsItem(this);
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Electronics getElectronics() {
		return electronics;
	}

	public void setElectronics(Electronics electronics) {
		this.electronics = electronics;
	}

	public List<ImgElectronicsItem> getImgElectronicsItems() {
		return imgElectronicsItems;
	}

	public void setImgElectronicsItems(List<ImgElectronicsItem> imgElectronicsItems) {
		this.imgElectronicsItems = imgElectronicsItems;
	}

}

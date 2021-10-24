package vn.ptit.entities.shoes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import vn.ptit.entities.clothes.ImgClothesItem;

@Entity
@Table(name = "ShoesItem")
public class ShoesItem {
	@Id
	@Column(name="BarCode", nullable = false, length = 255)
	private String barCode;
	
	@Column(name="Price", nullable = false)
	private double price;
	
	@Column(name="Discount", nullable = true)
	private double discount;
	
	@Column(name="Slug", nullable = false, length = 1000)
	private String slug;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ShoesID")
	private Shoes shoes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shoesItem", fetch = FetchType.EAGER)
	private List<ImgShoesItem> imgShoesItems = new ArrayList<>();
	
	public List<ImgShoesItem> getImgProducts() {
		return imgShoesItems;
	}

	public void setImgProducts(List<ImgShoesItem> imgShoesItems) {
		this.imgShoesItems = imgShoesItems;
	}

	public void addImgShoesItem(ImgShoesItem imgShoesItem) {
		imgShoesItems.add(imgShoesItem);
		imgShoesItem.setShoesItem(this);
	}

	public void removeImgShoesItem(ImgShoesItem imgShoesItem) {
		imgShoesItems.remove(imgShoesItem);
		imgShoesItem.setShoesItem(null);
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

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}

	public List<ImgShoesItem> getImgShoesItems() {
		return imgShoesItems;
	}

	public void setImgShoesItems(List<ImgShoesItem> imgShoesItems) {
		this.imgShoesItems = imgShoesItems;
	}
	
}

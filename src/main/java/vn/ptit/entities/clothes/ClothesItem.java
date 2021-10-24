package vn.ptit.entities.clothes;

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

@Entity
@Table(name = "ClothesItem")
public class ClothesItem {
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
	@JoinColumn(name = "ClothesID")
	private Clothes clothes;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clothesItem", fetch = FetchType.EAGER)
	private List<ImgClothesItem> imgClothesItems = new ArrayList<>();
	
	public List<ImgClothesItem> getImgProducts() {
		return imgClothesItems;
	}

	public void setImgProducts(List<ImgClothesItem> imgClothesItems) {
		this.imgClothesItems = imgClothesItems;
	}

	public void addImgClothesItem(ImgClothesItem imgClothesItem) {
		imgClothesItems.add(imgClothesItem);
		imgClothesItem.setClothesItem(this);
	}

	public void removeImgClothesItem(ImgClothesItem imgClothesItem) {
		imgClothesItems.remove(imgClothesItem);
		imgClothesItem.setClothesItem(null);
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

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
}

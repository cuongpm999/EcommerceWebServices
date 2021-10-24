package vn.ptit.entities.book;

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
@Table(name = "BookItem")
public class BookItem {
	@Id
	@Column(name = "BarCode", length = 255)
	private String barCode;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	@Column(name = "Discount")
	private double discount;
	
	@Column(name = "Slug", nullable = false, length = 1000)
	private String slug;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BookID")
	private Book book;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bookItem", fetch = FetchType.LAZY)
	private List<ImgBookItem> imgBookItems = new ArrayList<>();
	
	public List<ImgBookItem> getImgBookItems() {
		return imgBookItems;
	}

	public void setImgBookItems(List<ImgBookItem> imgBookItems) {
		this.imgBookItems = imgBookItems;
	}

	public void addImgBookItem(ImgBookItem imgBookItem) {
		imgBookItems.add(imgBookItem);
		imgBookItem.setBookItem(this);
	}

	public void removeImgBookItem(ImgBookItem imgBookItem) {
		imgBookItems.remove(imgBookItem);
		imgBookItem.setBookItem(null);
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}

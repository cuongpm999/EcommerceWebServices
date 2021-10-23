package vn.ptit.entities.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookItem")
public class BookItem {
	@Id
	@Column(name = "BarCode")
	private String barCode;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	@Column(name = "Discount")
	private double discount;
	
	@Column(name = "Slug", nullable = false)
	private String slug;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BookID")
	private Book book;

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

package vn.ptit.entities.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import vn.ptit.entities.clothes.ClothesItem;

@Entity
@Table(name = "LineClothesItem")
public class LineClothesItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Quanity")
	private int quanity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ClothesItemBarCode")
	private ClothesItem clothesItem;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CartID")
	private ShoppingCart shoppingCart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public ClothesItem getClothesItem() {
		return clothesItem;
	}

	public void setClothesItem(ClothesItem clothesItem) {
		this.clothesItem = clothesItem;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	
}

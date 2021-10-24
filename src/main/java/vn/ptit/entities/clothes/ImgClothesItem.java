package vn.ptit.entities.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ImgClothesItem")
public class ImgClothesItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "Path", nullable = false, length = 100)
	private String path;
	
	@Column(name = "Mime", nullable = false, length = 100)
	private String mine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ClothesItemBarCode")
	private ClothesItem clothesItem;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMine() {
		return mine;
	}

	public void setMine(String mine) {
		this.mine = mine;
	}

	public ClothesItem getClothesItem() {
		return clothesItem;
	}

	public void setClothesItem(ClothesItem clothesItem) {
		this.clothesItem = clothesItem;
	}
	
}

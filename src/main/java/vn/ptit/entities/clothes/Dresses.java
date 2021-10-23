package vn.ptit.entities.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Dresses")
@PrimaryKeyJoinColumn(name="ClothesID")
public class Dresses extends Clothes{
	@Column(name = "Size", nullable = false, length = 255)
	private String size;
	@Column(name = "Length", nullable = false, length = 255)
	private String length;
	@Column(name = "Pattern", nullable = false, length = 255)
	private String pattern;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}

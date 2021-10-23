package vn.ptit.entities.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Jeans")
@PrimaryKeyJoinColumn(name="ClothesID")
public class Jeans extends Clothes{
	
	@Column(name = "Pipe", nullable = false, length = 255)
	private String pipe;
	@Column(name = "Size", nullable = false, length = 255)
	private String size;
	
	public String getPipe() {
		return pipe;
	}
	public void setPipe(String pipe) {
		this.pipe = pipe;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}

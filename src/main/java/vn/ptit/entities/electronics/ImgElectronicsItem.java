package vn.ptit.entities.electronics;

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

@Entity
@Table(name = "ImgElectronicsItem")
public class ImgElectronicsItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name", length = 100, nullable = false)
	private String name;

	@Column(name = "Path", length = 100, nullable = false)
	private String path;

	@Column(name = "Mime", length = 100, nullable = false)
	private String mime;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ElectronicsItemBarCode")
	private ElectronicsItem electronicsItem;

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

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public ElectronicsItem getElectronicsItem() {
		return electronicsItem;
	}

	public void setElectronicsItem(ElectronicsItem electronicsItem) {
		this.electronicsItem = electronicsItem;
	}

}

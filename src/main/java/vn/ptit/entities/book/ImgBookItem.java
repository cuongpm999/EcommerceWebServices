package vn.ptit.entities.book;

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
@Table(name = "ImgBookItem")
public class ImgBookItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// tự động tăng id
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "Path", nullable = false, length = 100)
	private String path;
	
	@Column(name = "Mime", nullable = false, length = 100)
	private String mime;
}

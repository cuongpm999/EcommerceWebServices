package vn.ptit.entities.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// tự động tăng id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "Biography", nullable = false, length = 255)
	private String biography;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	
}

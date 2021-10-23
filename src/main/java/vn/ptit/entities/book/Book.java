package vn.ptit.entities.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// tự động tăng id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Title", nullable = false, length = 255)
	private String title;
	
	@Column(name = "Summary", nullable = false, length = 255)
	private String summary;
	
	@Column(name = "Pages", nullable = false)
	private int pages;
	
	@Column(name = "Language", nullable = false, length = 255)
	private String language;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PublisherID")
	private Publisher publisher;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Book_Author", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "AuthorID"))
	private List<Author> authors = new ArrayList<>();

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}

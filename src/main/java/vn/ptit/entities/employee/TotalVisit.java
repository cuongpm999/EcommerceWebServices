package vn.ptit.entities.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TotalVisit")
public class TotalVisit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "IpAddress", nullable = false, length = 100)
	private String ipAddress;

	@Column(name = "DateVisited", nullable = false)
	private Date dateVisited;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getDateVisited() {
		return dateVisited;
	}

	public void setDateVisited(Date dateVisited) {
		this.dateVisited = dateVisited;
	}

}

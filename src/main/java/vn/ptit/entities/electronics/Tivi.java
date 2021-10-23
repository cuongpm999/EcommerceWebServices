package vn.ptit.entities.electronics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Tivi")
@PrimaryKeyJoinColumn(name="ElectronicsID")
public class Tivi extends Electronics{
	@Column(name = "Connector", nullable = false, length = 255)
	private String connector;

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}
	
}

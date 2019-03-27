package io.java.springbootstarter.model3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aia")
public class Topics3 {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id")	
	private String id;

	@Column(name = "AIA_status")
	private String status3;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus3() {
		return status3;
	}

	public void setStatus3(String status3) {
		this.status3 = status3;
	}

	public Topics3(String id,String status3) {
		super();
		this.id = id;
		this.status3 = status3;

	}

	public Topics3() {
		super();
	}
}

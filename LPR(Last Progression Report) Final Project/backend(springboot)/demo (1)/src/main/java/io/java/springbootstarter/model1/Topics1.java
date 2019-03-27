package io.java.springbootstarter.model1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cordys")
public class Topics1 {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id")	
	private String id;

	@Column(name = "Cordys_statusl")
	private String status1;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public Topics1(String id, String status1) {
		super();
		this.id = id;
		this.status1 = status1;
	}

	public Topics1() {
		super();
	}

}

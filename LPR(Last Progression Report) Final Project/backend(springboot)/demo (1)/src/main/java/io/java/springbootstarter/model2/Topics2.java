package io.java.springbootstarter.model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="siebel")
public class Topics2 {
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id")	
	private String id;

	@Column(name = "SIEBEL_status")
	private String status2;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public Topics2(String id,String status2) {
		super();
		this.id = id;
		this.status2 = status2;

	}

	public Topics2() {
		super();
	}
}

package io.java.springbootstarter.topic;


//class for storing data coming from different databases

public class Topic {
	private String id, status1, status2, status3, status4, status5;
	public Topic() {
		
	}
	public Topic(String id,String status1,String status2,String status3,String status4,String status5){
		super();
		this.id =id;
		this.status1=status1;
		this.status2=status2;
		this.status3=status3;
		this.status4=status4;
		this.status5=status5;
	}
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
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public String getStatus3() {
		return status3;
	}
	public void setStatus3(String status3) {
		this.status3 = status3;
	}
	public String getStatus4() {
		return status4;
	}
	public void setStatus4(String status4) {
		this.status4 = status4;
	}
	public String getStatus5() {
		return status5;
	}
	public void setStatus5(String status5) {
		this.status5 = status5;
	}
	
	
}
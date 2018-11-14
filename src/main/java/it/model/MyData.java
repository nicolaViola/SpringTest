package it.model;

public class MyData {
	
	private String owner;
	private String comment;
	
	public MyData(){}
	
	public MyData(String owner, String comment) {
		this.owner = owner;
		this.comment = comment;
	}

	public String getOwner() {
		return owner;
	}

	public String getComment() {
		return comment;
	}
	
	

}

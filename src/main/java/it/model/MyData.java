package it.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name = "employee")
@XmlAccessorType(XmlAccessType.NONE)
public class MyData implements Serializable{
	@XmlAttribute
	private String owner;
	@XmlAttribute
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

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}

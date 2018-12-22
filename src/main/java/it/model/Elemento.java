package it.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Elemento {
	
	public Elemento(){}
	
	@Id
	private long id;
	
	private String nome;
	
	public Elemento(long id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	

	
}

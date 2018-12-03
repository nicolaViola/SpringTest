package it.model;

public class Persona {
	
	private String nome;
	private String cognome;
	private boolean enabled;
	
	public Persona(String nome, String cognome, boolean enabled) {
		this.nome = nome;
		this.cognome = cognome;
		this.enabled = enabled;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}

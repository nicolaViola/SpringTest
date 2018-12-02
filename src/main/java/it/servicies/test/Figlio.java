package it.servicies.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy(true)
//@Scope("prototype")
public class Figlio {
	
	
	
	public String xxx;
	
	public Figlio(){
		System.out.println("inizializzazione Figlio");
	}
	
	public String saluta(){
		return "ciao";
	}
	
	public static int ccc() {
		return 8;
	}
	

}

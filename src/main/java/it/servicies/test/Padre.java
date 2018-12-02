package it.servicies.test;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.Nullable;

@Component()
//@Scope("prototype")
public class Padre implements InitializingBean, IPadre{
	
	@Value("#{systemProperties['java.runtime.name']}")
	private String jvmName;
	
	@Value("#{systemEnvironment['JAVA_HOME']}")
	private String homeName;
	
	@Value("#{environment['defaultProfiles']}")
	private String defaultName;
	
//	@Value(value = "#{@figlio.saluta()}")
//	private String nome;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Value(value = "#{T(it.servicies.test.Figlio).ccc() }")
	private int randomNumber;

	//@Override
	public int getRandomNumber() {
		if(randomNumber >10)
			throw new RuntimeException("noooo");
		
		return randomNumber;
	}
	
	

	//@Override
	public int otherMethod() throws Exception{
		System.out.println("altro metodo");
		return 0;
	}
	
	

	
//	public void setRandomNumber(int randomNumber) {
//		this.randomNumber = randomNumber;
//	}
	
	
	
	//@Lazy(true)
	//@Autowired
//	private Figlio figlio;
	//private Optional<Figlio1> figlio1;
	
//	public Padre(@Autowired(required = false) Figlio figlio){
//		this.figlio = figlio;
//	}
	
//	@Value(value = "#{T(java.lang.Math).random() * 100 + 1}")
//	private int saluto;
//	
//	public void ciao(){
//		System.out.println(saluto);
//	}

	
//	public Padre(@Autowired(required = false) Figlio figlio,  Optional<Figlio1> figlio1){
//		System.out.println("inizializzazione Padre");
//		this.figlio = figlio;
//		this.figlio1 = figlio1;
//	}

	//public Padre(){}

	
	



//	public optional<figlio1> getfiglio1() {
//		return figlio1;
//	}


	
//	private void setFiglio(Figlio figlio) {
//		this.figlio = figlio;
//	}


}

package it.configuration;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import it.servicies.test.Figlio;
import it.servicies.test.Figlio1;
import it.servicies.test.Padre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages={"it.servicies", "it.aop"})

//@ComponentScan(basePackages={"it"})

@PropertySource("classpath:property/nicola.properties")
@EnableAspectJAutoProxy
public class TestConfiguration {
//	@Autowired
//	private Figlio figlio;
	
	@Bean
	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	

//	@Bean//(initMethod="initialize3")
//	public Figlio figlio(){
//		return new Figlio();
//	}
//	
//	@Bean//(initMethod="initialize3")
//	public Padre padre(){
//		return new Padre(null);
//	}
	
//	@Bean
//	public Padre[] padri(){
//		Padre[]  x = new Padre[3];
//		x[0] = padre();
//		return x;
//	}
	
//	@Bean//(initMethod="initialize3")
//	public Figlio figlio(){
//		return null;
//	}
	
//	@Bean//(initMethod="initialize3")
//	public Figlio1 figlio1(){
//		return new Figlio1();
//	}
}

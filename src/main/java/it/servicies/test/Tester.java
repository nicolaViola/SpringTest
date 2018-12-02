package it.servicies.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Nicola

public class Tester {
	
	@Autowired
	private IPadre padre;
	
	@NicolaMethod
	public int doSomething(Altro altro) throws Exception{
		padre.otherMethod();
		
//		Altro altro = new Altro();
//		altro.doSomething();
		return 0;
	}

}

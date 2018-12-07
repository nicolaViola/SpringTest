package it.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.configuration.TestConfiguration;
import it.servicies.ITransactionalService;
import it.servicies.impl.PropagationService;
import it.servicies.impl.TransactionalService;

public class LauncherPropagation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);
		PropagationService ts = ac.getBean(PropagationService.class);
		
		ts.test();
System.out.println("ok");
	}

}

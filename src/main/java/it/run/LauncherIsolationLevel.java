package it.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.configuration.TestConfiguration;
import it.model.TestTable;
import it.servicies.ITransactionalService;

public class LauncherIsolationLevel {

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);
		ITransactionalService ts = ac.getBean(ITransactionalService.class);
		
		Thread legge = new Thread(new Legge(ts));
		legge.start();

		Thread scrive = new Thread(new Scrive(ts));
		scrive.start();
		
		
		Thread leggeA = new Thread(new Legge(ts));
		leggeA.start();
		
		// TODO Auto-generated method stub

		System.out.println("fine");
		
		
	}

}

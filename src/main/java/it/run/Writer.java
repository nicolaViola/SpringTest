package it.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.configuration.TestConfiguration;
import it.model.TestTable;
import it.servicies.ITransactionalService;

public class Writer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);
		ITransactionalService ts = ac.getBean(ITransactionalService.class);
		ts.updateTest(new TestTable("pippo", "baudo", 90));
		System.out.println("s");
	}

}

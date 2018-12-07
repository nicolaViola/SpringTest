package it.run;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.model.TestTable;
import it.servicies.ITransactionalService;

public class Scrive implements Runnable{
	
private ITransactionalService transactionalService;
	
	public Scrive(ITransactionalService transactionalService) {
		this.transactionalService = transactionalService;
	}

	@Override
	public void run() {

		transactionalService.updateTest(new TestTable("pippo", "baudo", 43));
		System.out.println("s");
		//throw new RuntimeException();
	}

}

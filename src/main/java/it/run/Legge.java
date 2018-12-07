package it.run;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.model.TestTable;
import it.servicies.ITransactionalService;

public class Legge implements Runnable{

	private ITransactionalService transactionalService;
	
	public Legge(ITransactionalService transactionalService) {
		this.transactionalService = transactionalService;
	}

	@Override
	public void run() {
		
		List<TestTable> tests = transactionalService.getTestByEta(43);
		System.out.println("s");
		
		List<TestTable> tests2 = transactionalService.getTestByEta(43);
		System.out.println("s");
		
	}

}

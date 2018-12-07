package it.servicies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PropagationService {
	
	@Autowired
	private TransactionalService transactionalService;
	
	@Transactional
	public void test(){
		
		transactionalService.getTestByEta(40);
		
	}

}

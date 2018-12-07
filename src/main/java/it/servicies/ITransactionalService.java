package it.servicies;

import java.util.List;

import it.model.TestTable;

public interface ITransactionalService {
	
	public List<TestTable> getTestByEta(int eta);
	
	public void updateTest(TestTable test);

}

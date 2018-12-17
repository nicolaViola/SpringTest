package it.servicies;

import java.util.List;

import it.model.TestTable;

public interface ITransactionalService {
	
	public List<TestTable> getTestByEta(int eta);
	
	public List<TestTable> getTest();
	
	public void updateTest(TestTable test);
	
//	public void updateTest2(TestTable test);

}

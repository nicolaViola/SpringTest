package transactionalTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

import it.configuration.TestConfiguration;
import it.model.TestTable;
import it.servicies.ITrackerService;
import it.servicies.ITransactionalService;
import it.servicies.impl.TransactionalService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MyTest {
	
	@Autowired
	private TransactionalService transactionalService;

	@Autowired
	private PlatformTransactionManager transactionManager;
	@Test
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void test() {
		
		AnnotationTransactionAspect.aspectOf().setTransactionManager(transactionManager);
		
		transactionalService.updateTest(new TestTable("pippo", "baudo", 90));
		
		//transactionalService.updateTest2(new TestTable("pippo2", "baudo2", 92));
		List<TestTable> test = transactionalService.getTest();
		
		for(TestTable row : test){
			System.out.println(row.getNome());
		}
		
		System.out.print(test);
	}

}

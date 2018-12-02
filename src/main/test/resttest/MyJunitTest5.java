package resttest;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import it.configuration.TestConfiguration;
import it.servicies.ITrackerService;
import it.servicies.impl.TrackerService;
import it.servicies.test.Altro;
import it.servicies.test.Figlio;
import it.servicies.test.Figlio1;
import it.servicies.test.IPadre;
import it.servicies.test.IPerson;
import it.servicies.test.MyBeanFactoryPostProcessor;
import it.servicies.test.MyBeanPostProcessor;
import it.servicies.test.Padre;
import it.servicies.test.Tester;


//@SpringJUnitConfig(classes = TestConfiguration.class)

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
//@TestPropertySource(locations = "classpath:property/nicola.properties", properties="qty=55")
public class MyJunitTest5 {
	
	@Autowired
	private ITrackerService trackerService;
	
	@Autowired
	private IPadre padre;
	
//	@Autowired
//	private MyBeanFactoryPostProcessor myBeanFactoryPostProcessor;
//	
//	@Autowired
//	private MyBeanPostProcessor myBeanPostProcessor;
//	
//	
//	
//	@Autowired
//	private Padre[] padri;

	@Test
	public void test() {
		trackerService.forTest();
		Figlio figlio = new Figlio();
		ReflectionTestUtils.setField(figlio, "quantita", "w");
		
		ReflectionTestUtils.invokeSetterMethod(figlio, "nome", "x");
		System.out.println(figlio);
	}
	
	@Test
	public void testPadre() {
		//Figlio figlio = padre.getFiglio();
	//	System.out.println(padre);

//		Optional<Figlio1> f1 = padre.getFiglio1();
//		f1.get();
		//C
		
		
	}
	@Test
	public void testApplicationContext() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
		Environment env = context.getEnvironment();
		
		Padre c = context.getBean(Padre.class);
		
		//padre.getFiglio();
		System.out.println(padre);
		System.out.println(env.containsProperty("java.runtime.name"));
		
	}
	
//	@Test
//	public void testSpel() {
//		
//		System.out.println(padre);
//		
//		System.out.println(padre.getRandomNumber());
//	}
	@Autowired
	private Tester tester;
	
	@Test
	public void testAop() throws Exception {
//		int y = padre.getRandomNumber();
//		System.out.println(y);
		
		//padre.otherMethod();
		
//		Altro altro = new Altro();
//		altro.doSomething();
		
		tester.doSomething(new Altro());	
		
		System.out.println("fine");
	}

}

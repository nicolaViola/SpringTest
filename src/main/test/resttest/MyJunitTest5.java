package resttest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import it.configuration.TestConfiguration;
import it.model.TestTable;
import it.model.User;
import it.servicies.ITrackerService;
import it.servicies.ITransactionalService;
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

	//@Test
	public void test() {
		trackerService.forTest();
		Figlio figlio = new Figlio();
		ReflectionTestUtils.setField(figlio, "quantita", "w");
		
		ReflectionTestUtils.invokeSetterMethod(figlio, "nome", "x");
		System.out.println(figlio);
	}
	
	//@Test
	public void testPadre() {
		//Figlio figlio = padre.getFiglio();
	//	System.out.println(padre);

//		Optional<Figlio1> f1 = padre.getFiglio1();
//		f1.get();
		//C
		
		
	}
//	@Test
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
	
	//@Test
	public void testAop() throws Exception {
//		int y = padre.getRandomNumber();
//		System.out.println(y);
		
		//padre.otherMethod();
		
//		Altro altro = new Altro();
//		altro.doSomething();
		
		tester.doSomething(new Altro());	
		
		System.out.println("fine");
	}
	
	@Autowired
	JdbcTemplate myJdbcTemplate;
	
	@Test
	public void testJdbcRowMapper() throws Exception {
		
		
		Collection<User> users = (Collection<User>) myJdbcTemplate.query("select username, password, enabled from users ", new RowMapper<User>() {
			
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));
			}
		});
		
		for(User user : users) {
			System.out.println(user.getUsername());
			
		}
	}
	
	@Test
	public void testJdbcRowcalBackHandler() throws Exception {
		
		myJdbcTemplate.query("select username, password, enabled from users", new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//while(rs.next())
					System.out.println(rs.getString(1));
				
			}
		});
		
		
	}
	
	@Autowired
	private DataSource xxx;
	
	@Test
	public  void testJdbcResultSetExtractor() throws Exception {
		JdbcTemplate t = new JdbcTemplate(xxx);
		
		t.queryForList("select username from users", String.class);
		
		t.queryForList("select username, password, enabled from users");
		
		//myJdbcTemplate.queryForList("select username, password, enabled from users");
		
		
		
		Collection<User> users = myJdbcTemplate.query("select username, password, enabled from users", new ResultSetExtractor<Collection<User>>() {

			@Override
			public Collection<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Collection<User> users = new ArrayList<>();
				while(rs.next()){
					users.add(new User(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
					
				}
				return users;
			}
		});
		
		for(User user : users) {
			System.out.println(user.getUsername());
			
		}
	}
	
	@Autowired
	private ITransactionalService transactionalService;
	
	@Test
	public void testTestServiceSelect(){
		
		transactionalService.updateTest(new TestTable("pippo", "baudo", 90));
		
		List<TestTable> test = transactionalService.getTestByEta(90);
		
		System.out.print(test);
		
	}
}




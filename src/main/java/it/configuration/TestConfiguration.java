package it.configuration;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.servicies.test.Figlio;
import it.servicies.test.Figlio1;
import it.servicies.test.Padre;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages={"it.servicies", "it.aop"})

//@ComponentScan(basePackages={"it"})

@PropertySource("classpath:property/nicola.properties")
//@EnableAspectJAutoProxy

@EnableTransactionManagement
public class TestConfiguration {
//	@Autowired
//	private Figlio figlio;
	
	public PlatformTransactionManager transactionManager(){
		
		return new DataSourceTransactionManager();
	}
	
	@Bean
	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean("xxx")
	public DataSource xxx() {
		
//		PasswordEncoder bCryptPasswordEncoder = passwordEncoder();
//		//String p = bCryptPasswordEncoder.encode("admin");
//		System.out.println(bCryptPasswordEncoder.matches("admin", "$2a$08$YN2y9ehNoknkvyPn5iVNEeb8qnCO5VDKs7FkmoM8hQjt2IZh/ACza"));
//		//System.out.println(p);
		
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScripts("classpath:db/schema.sql", 
						"classpath:db/test-data.sql")
			.build();
		return db;
	}
	
	
	@Bean
	public JdbcTemplate myJdbcTemplate(){
		
		return new JdbcTemplate(xxx());
		
	}

//	@Bean//(initMethod="initialize3")
//	public Figlio figlio(){
//		return new Figlio();
//	}
//	
//	@Bean//(initMethod="initialize3")
//	public Padre padre(){
//		return new Padre(null);
//	}
	
//	@Bean
//	public Padre[] padri(){
//		Padre[]  x = new Padre[3];
//		x[0] = padre();
//		return x;
//	}
	
//	@Bean//(initMethod="initialize3")
//	public Figlio figlio(){
//		return null;
//	}
	
//	@Bean//(initMethod="initialize3")
//	public Figlio1 figlio1(){
//		return new Figlio1();
//	}
}

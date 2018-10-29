package it.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"it"})
@ImportResource("/WEB-INF/configuration/db-config.xml")
public class WebConfig implements WebMvcConfigurer{
	
	
	@Bean
	InternalResourceViewResolver getViewResolver(){	
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp" );
		resolver.setRequestContextAttribute("requestContext");
		return resolver;
	}
	
	@Bean
	public DataSource dataSource2() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
			.addScript("classpath:db/schema.sql")
			.addScript("classpath:db/test-data.sql")
			.build();
		return db;
	}

}

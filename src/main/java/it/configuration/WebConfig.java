package it.configuration;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"it"})
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/myLogin");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
//	@Bean
//	InternalResourceViewResolver getViewResolver(){	
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/jsp/");
//		resolver.setSuffix(".jsp" );
//		resolver.setRequestContextAttribute("requestContext");
//		return resolver;
//	}


	@Bean
	public DataSource dataSource() {
		
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
	
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		// TODO Auto-generated method stub
//		//WebMvcConfigurer.super.configureContentNegotiation(configurer);
//		configurer.defaultContentType(MediaType.APPLICATION_JSON);
//	}
	
//	@Bean
//	public ContentNegotiationManager contentNegotiationManager(){
//		ContentNegotiationManager contentNegotiationManager = new ContentNegotiationManager();
//		contentNegotiationManager.resolveFileExtensions(MediaType.APPLICATION_JSON);
//		return contentNegotiationManager;
//	}
	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new Jaxb2RootElementHttpMessageConverter());
//		//WebMvcConfigurer.super.configureMessageConverters(converters);
//	}
	

}

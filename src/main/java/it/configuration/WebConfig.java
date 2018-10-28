package it.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
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

}

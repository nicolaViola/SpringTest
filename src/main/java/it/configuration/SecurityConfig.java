package it.configuration;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder encoder;

	//Intercettare una requesr
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		.authorizeRequests()
		.antMatchers("/myLogin").anonymous()
			.antMatchers("/*").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER") //oppure usare hasAnyRole senza ROLE_  hasAnyRole("ADMIN", "USER")
		.and()
			.formLogin()
			
//			.usernameParameter("username") 
//			.passwordParameter("password") 
//			.loginProcessingUrl("/login")
//		    .loginPage("/myLogin")
//		    .loginProcessingUrl("/perform_login")
		    
			.failureForwardUrl("/noAuthorization.jsp")
			.successHandler(simpleUrlAuthenticationSuccessHandler())
		.and()
			.exceptionHandling().accessDeniedPage("/accessDenied.jsp");
//		.and()
//			.logout()
//			.logoutSuccessHandler(logoutSuccessHandler())
//			.logoutSuccessUrl("/");
	}
	
	//Autenticazione contro un datasource
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	public AuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler(){
		return new SimpleUrlAuthenticationSuccessHandler("/welcome");
	}
	
//	@Bean
//	public LogoutSuccessHandler logoutSuccessHandler(){
//		return new SimpleUrlLogoutSuccessHandler();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
	
}

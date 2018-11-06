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

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity
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
		.antMatchers("/*").access("hasAnyRole('ADMIN', 'USER') and hasIpAddress('127.0.0.1')") //.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")////oppure usare hasAnyRole senza ROLE_  hasAnyRole("ADMIN", "USER")
		.and()
			.formLogin()
					.failureForwardUrl("/noAuthorization.jsp")
					.successHandler(simpleUrlAuthenticationSuccessHandler())
				.and()
					.exceptionHandling().accessDeniedPage("/accessDenied.jsp")
			.and()
				.requiresChannel()
					.antMatchers("/welcome")
				.requiresSecure();
		
		//http.csrf().disable();
	}
	
	//Autenticazione contro un datasource
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
		//auth.userDetailsService(new MyUserDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public AuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler(){
		return new SimpleUrlAuthenticationSuccessHandler("/welcome");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
	
}

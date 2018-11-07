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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	//Intercettare una requesr
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/*").access("hasAnyRole('ADMIN', 'USER')") //.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")////oppure usare hasAnyRole senza ROLE_  hasAnyRole("ADMIN", "USER")
		.and()
			.formLogin()
				.loginPage("/myLogin").permitAll().failureUrl("/myLogin?error=error")
				
					//.failureForwardUrl("/noAuthorization.jsp")
					.successHandler(simpleUrlAuthenticationSuccessHandler())
			//	.and().rememberMe()
				.and()
					.exceptionHandling().accessDeniedPage("/accessDenied.jsp")
				// If CSRF protection is enabled (default), then the request must also be a POST. 	
				.and()
					.logout()//.logoutUrl("/myLogout").logoutSuccessUrl("/myLogout?l=l")
			.and()
				.requiresChannel()
					.antMatchers("/welcome")
				.requiresSecure();
		
	//	http.csrf().disable(); //default il csrf è abilitato server side
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
		return new AccessDeniedHandlerImpl();
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

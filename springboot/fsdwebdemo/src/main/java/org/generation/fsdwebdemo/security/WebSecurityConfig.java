package org.generation.fsdwebdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	// Use dependency injection method to inject the DataSource (interface) object
	//into this WebSecurityConfig class so tt we can use the properties/methods
	//from the DataSource object

	// Purpose: to make use of the details we put in the application.properties
	//to be able to make a connection to our MySQL server and access our Schema
	@Autowired // @Autowired = dependency injection
	private DataSource dataSource;

	/*  https://www.tabnine.com/code/java/methods/org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer/authoritiesByUsernameQuery
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		// When a user is authenticated, Spring Security object will create a user session (backend)
		// Spring Security object will also be responsible to manage the session (e.g. timeout, error)
		// Spring Security object will need to end the user session if logout/timeout

		// in sql query, get info from the frontend through the ? symbol
		// sending of info from frontend is through thymeleaf

		// usersByUsernameQuery is sql query method provided by AuthenticationManagerBuilder
		// the query used here gets the row tt matches what the frontend send
		// usersByUsernameQuery will check that the password matches and enabled=1
		// authoritiesByUsernameQuery - retrieve role of this user

		auth.jdbcAuthentication()
				.passwordEncoder(new BCryptPasswordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?");
	}

	/*
	https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html
	*/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// After authentication is done and user is logged in and session is active
		//need to setup the security policy for the http pages the user is able to access
		http.csrf().disable();

		http.formLogin().loginPage("/login");

		http.formLogin().defaultSuccessUrl("/productForm", true);

		http.logout().logoutSuccessUrl("/index");

		// Specify which pages to allow users to access w/o logging in
		//and which pages users with "ADMIN" role can access
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/product", "/index", "/item/**", "/images/**", "/js/**", "/css/**", "/productimages/**", "/login", "/aboutus").permitAll()
				.requestMatchers("/productForm/**").hasRole("ADMIN")
//				.requestMatchers("/dashboard/**").hasRole("USER")
		);
		return http.build();
	}
}
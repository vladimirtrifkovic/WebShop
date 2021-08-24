package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.BuyerDetailsService;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new BuyerDetailsService();
	}
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
					http
					.csrf().disable()
					.authorizeRequests()
//					.antMatchers("/books/addNew", "/books/update", "/books/delete").hasAnyAuthority("ADMIN", "CREATOR") //added
					.antMatchers(
							"/login", 
							"/resources/**", 
							"/css/**", 
							"/fonts/**", 
							"/img/**",
							"/js/**").permitAll()
					.antMatchers(
							"/register", 
							"/resources/**", 
							"/css/**", 
							"/fonts/**", 
							"/img/**",
							"/js/**").permitAll()
					.antMatchers("/buyers/addNew").permitAll()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.permitAll()
					.and()
					.logout().invalidateHttpSession(true)
					.clearAuthentication(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login").permitAll();
					
				            
					
	
				}
	
	
}
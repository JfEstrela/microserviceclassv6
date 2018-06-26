package com.jf.estrela.microserviceclass.microserviceclass.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encoder() {return new BCryptPasswordEncoder();}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.builder();
		userBuilder.username("barry").password("$2a$04$CYyTFttr1Iszv8hwzYLLtOTIol431ZWGBlU50Y0o/cGQRB448jAAC").roles("COORDINATOR","TEACHER");
		UserBuilder userBuilder2 = User.builder();
		userBuilder2.username("root").password("$2a$04$yiwaWRYkTVEfZTQ66qVCd.s7gfyJw2gnDwCvdoFNqIrgxl/Oh2vPq").roles("TEACHER");
            auth.inMemoryAuthentication().withUser(userBuilder).withUser(userBuilder2);
                
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/disciplina/**").hasAnyRole("COORDINATOR")
			.antMatchers("/aluno/**").hasAnyRole("TEACHER","COORDINATOR")
			.anyRequest().fullyAuthenticated()
			.and().httpBasic().and().csrf().disable();
	}
	

}

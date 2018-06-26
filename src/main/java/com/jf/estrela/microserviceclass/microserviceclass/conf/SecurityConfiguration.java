package com.jf.estrela.microserviceclass.microserviceclass.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.builder();
		userBuilder.username("barry").password("alertse").roles("COORDINATOR","TEACHER");
		UserBuilder userBuilder2 = User.builder();
		userBuilder2.username("root").password("root").roles("TEACHER");
            auth.inMemoryAuthentication().withUser(userBuilder).withUser(userBuilder2);
                
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/disciplina/**").hasAnyRole("COORDINATOR")
			.antMatchers("/aluno/**").hasAnyRole("TEACHER")
			.anyRequest().fullyAuthenticated()
			.and().httpBasic().and().csrf().disable();
	}
	

}

package com.mindtree.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.mindtree.entity.User;
import com.mindtree.service.CustomerService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private CustomerService customerService;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/test","/", "/home", "/about","/signupcustom","/signup").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN").antMatchers("/user/**").hasAnyRole("USER").anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Prathik").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Prathik").password("123").roles("USER");
        List<User> customerinfo = customerService.findCust();
        //users registered through signup
        for(int i=0;i<customerinfo.size();i++) {
        	auth.inMemoryAuthentication().withUser(customerinfo.get(i).getCustomername()).password(customerinfo.get(i).getPassword()).roles("USER");
        }
    }

}

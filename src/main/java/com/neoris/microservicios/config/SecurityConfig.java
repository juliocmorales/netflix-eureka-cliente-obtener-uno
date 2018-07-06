package com.neoris.microservicios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
//import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UsuarioDetailsService usuarioDetailsService;	
	@Autowired
	private AutenticacionEntryPoint autentificacionEntryPoint;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
		    .and().httpBasic().realmName("Servicio Rest de Libros")
		    .authenticationEntryPoint(autentificacionEntryPoint);
		*/
		http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
		http.authorizeRequests().antMatchers("/").permitAll()
		     .anyRequest().fullyAuthenticated()
		     .and().httpBasic().authenticationEntryPoint(autentificacionEntryPoint)
		     .and().csrf().disable();
	} 
        @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder);
	}
} 
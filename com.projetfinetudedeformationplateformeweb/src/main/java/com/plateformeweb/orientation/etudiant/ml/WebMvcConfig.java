package com.plateformeweb.orientation.etudiant.ml;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	  public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	        .allowedMethods("*")
	        .allowedHeaders("*")
	        .allowedOrigins("http://localhost:4200")
	        .allowCredentials(false)
	        .maxAge(-1);
	  }
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/**").permitAll().anyRequest().authenticated();
		}
}

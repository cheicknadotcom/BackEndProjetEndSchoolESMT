package com.plateformeweb.orientation.etudiant.ml.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.plateformeweb.orientation.etudiant.ml.Services.UsersService;


@SuppressWarnings("deprecation")
@Configuration  
public class SecurityConfig extends WebSecurityConfigurerAdapter  
{
	@Autowired
	UsersService userDetailsService;
    
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// TODO Auto-generated method stub
    	super.configure(auth);
    	 auth.inMemoryAuthentication().withUser("user1").password("123").roles("USER","Admin"); 
    	//Par defaut le spring security utilise le Bscrypt  pour hash les mot de passe pour evite ça 
    	 auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("USER","Admin");
   
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	 //http.formLogin().loginPage("/La methode de login dans le controleur");
//    	//http.formLogin();
//    	//http.authorizeRequests().antMatchers("/save**/**","/delete**/**").authenticated();
//    	//http.authorizeRequests().anyRequests() .authenticated()
//    }
//    @Bean
//    public AuthenticationProvider getProvider() {
//        AppAuthProvider provider = new AppAuthProvider();
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/**").permitAll().anyRequest().authenticated();
		}
	public static String crypt(String str) {
	    if (str == null || str.length() == 0) {
	        throw new IllegalArgumentException(
	                "String to encrypt cannot be null or zero length");
	    }

	    StringBuffer hexString = new StringBuffer();

	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(str.getBytes());
	        byte[] hash = md.digest();

	        for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10) {
	                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	            } else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }
	    } catch (NoSuchAlgorithmException e) {
	    	System.out.println(e.getMessage());
	    }

	    return hexString.toString();
	}
}

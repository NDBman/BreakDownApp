package hu.unideb.inf.dandy.szd.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import hu.unideb.inf.dandy.szd.services.impl.UserDetailsServicesImpl;

@Configuration
@EnableWebSecurity
public class BreakDownAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery("select username,password, enabled from users where username=?");
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsServicesImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/admin/*").authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/")
				.failureUrl("/index?error")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll();
	}
}

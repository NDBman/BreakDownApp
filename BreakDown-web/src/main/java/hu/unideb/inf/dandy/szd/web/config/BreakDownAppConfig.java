package hu.unideb.inf.dandy.szd.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import hu.unideb.inf.dandy.szd.jpa.config.BreakDownJpaModulConfig;
import hu.unideb.inf.dandy.szd.services.config.BreakDownServiceModuleConfig;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.unideb.inf.dandy.szd.web")
@Import({BreakDownServiceModuleConfig.class, BreakDownJpaModulConfig.class})
public class BreakDownAppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}

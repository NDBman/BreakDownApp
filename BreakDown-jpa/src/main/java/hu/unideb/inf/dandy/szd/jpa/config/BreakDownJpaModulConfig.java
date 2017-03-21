package hu.unideb.inf.dandy.szd.jpa.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"hu.unideb.inf.dandy.szd.jpa.repo"})
public class BreakDownJpaModulConfig {

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"hu.unideb.inf.dandy.szd.jpa.entity"});
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setJpaProperties(setProperties());
		return em;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/BreakDownAppDB");
		dataSource.setUsername("postgres");
		dataSource.setPassword("dandy");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
	
	private Properties setProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}
}

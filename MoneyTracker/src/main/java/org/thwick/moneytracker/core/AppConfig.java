package org.thwick.moneytracker.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thwick.moneytracker.dao.AccountDAO;
import org.thwick.moneytracker.dao.CategoryDAO;
import org.thwick.moneytracker.dao.TransactionDAO;
import org.thwick.moneytracker.resources.CategoriesResource;

// http://aredko.blogspot.com/2013/01/going-rest-embedding-jetty-with-spring.html

@Configuration
@ComponentScan("org.thwick")
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/finances");
		ds.setUsername("finance");
		ds.setPassword("finance");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		vendorAdapter.setShowSql(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("org.thwick");
		factory.setDataSource(dataSource());
//		if (getJpaProperties() != null) {
//			factory.setJpaProperties(getJpaProperties());
//		}
		return factory;
	}

	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactoryBean()
				.getNativeEntityManagerFactory());
		
		return transactionManager;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		PersistenceAnnotationBeanPostProcessor processor = new PersistenceAnnotationBeanPostProcessor();
		processor.setDefaultPersistenceUnitName("jpa");
		
		return processor;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public CategoryDAO categoryDAO() {
		return new CategoryDAO();
	}

	@Bean
	public AccountDAO accountDAO() {
		return new AccountDAO();
	}
	
	@Bean
	public TransactionDAO transactionDAO() {
		return new TransactionDAO();
	}
	
	@Bean
	public CategoriesResource categoriesResource() {
		return new CategoriesResource();
	}
}

package org.thwick.moneytracker.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.thwick")
@EnableTransactionManagement
public class TestConfig {

	@Bean
	public AccountsResource accountResource() {
		return new AccountsResource();
	}
}

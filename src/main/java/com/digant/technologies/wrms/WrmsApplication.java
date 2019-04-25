package com.digant.technologies.wrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
/*@EnableTransactionManagement
@Configuration
@EnableJpaRepositories("com.digant.technologies.wrms.dao")*/
public class WrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrmsApplication.class, args);
	}

}

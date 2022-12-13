package com.luizfelipe.obra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizfelipe.obra.services.DBService;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDB() {
		//if (value.equals("create")) {
			this.dbService.instanciaDB();
		//}
		return false;
	}

}

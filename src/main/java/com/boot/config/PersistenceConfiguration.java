package com.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@Configurable
public class PersistenceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource datasource(){
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@FlywayDataSource
	public DataSource flywayDatasource(){
		return DataSourceBuilder.create().build();
		
	}
}

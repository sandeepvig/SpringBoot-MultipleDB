package com.vigs.springboot.multipledb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;

import com.vigs.springboot.multipledb.model.supplier.Supplier;
import com.vigs.springboot.multipledb.model.supplier.SupplierRepository;

@Configuration
@EnableJpaRepositories
(
basePackageClasses = SupplierRepository.class,
entityManagerFactoryRef = "supplierEntityManagerFactory"
		)

public class SupplierDBConfig {


	@Bean(name="supplierDataSource")
	@ConfigurationProperties(prefix = "app.supplier.datasource")
	DataSource createSupplierDataSource() {
		return DataSourceBuilder.create().build();
	}
	

	@Bean(name ="supplierEntityManagerFactory")
	AbstractEntityManagerFactoryBean registerSupllierDataSource(EntityManagerFactoryBuilder emfb, @Qualifier("supplierDataSource") DataSource supplierDS) {
		return emfb.dataSource(supplierDS).packages(Supplier.class).build();
	}
	
}

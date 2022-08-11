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

import com.vigs.springboot.multipledb.model.product.Product;
import com.vigs.springboot.multipledb.model.product.ProductRepository;


@Configuration
@EnableJpaRepositories(
		basePackageClasses = ProductRepository.class,
		entityManagerFactoryRef = "productEntityManagerFactory"
	
		)
public class ProductDBConfig {

	@Primary //vig: THIS IS NEEDED
	@Bean(name="productDataSource")
	@ConfigurationProperties(prefix = "app.product.datasource")
	DataSource createProductDataSource() {
		return DataSourceBuilder.create().build();
		
	}
	
	@Primary //vig: THIS IS NEEDED
	@Bean(name="productEntityManagerFactory")
	AbstractEntityManagerFactoryBean registerProductDataSource(EntityManagerFactoryBuilder emfb, @Qualifier("productDataSource") DataSource productDs) {
		return emfb.dataSource(productDs).packages(Product.class).build();
	}
	

}

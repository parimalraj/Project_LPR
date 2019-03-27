package io.java.springbootstarter.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//manual configuration for database3 (AIA) 
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "fooEntityManagerFactory",
  transactionManagerRef = "fooTransactionManager",
  basePackages = { "io.java.springbootstarter.repository.Topics3" }
)
public class db3Config {
	
	
	@Bean(name = "fooDataSource")
	  @ConfigurationProperties(prefix = "db3.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

@Bean(name = "fooEntityManagerFactory")
public LocalContainerEntityManagerFactoryBean 
barEntityManagerFactory(
  EntityManagerFactoryBuilder builder,
  @Qualifier("fooDataSource") DataSource dataSource
) {
  return
    builder
      .dataSource(dataSource)
      .packages("io.java.springbootstarter.model3")
      .persistenceUnit("Topics3")
      .build();
}
@Bean(name = "fooTransactionManager")
public PlatformTransactionManager barTransactionManager(
  @Qualifier("fooEntityManagerFactory") EntityManagerFactory
  fooEntityManagerFactory
) {
  return new JpaTransactionManager(fooEntityManagerFactory);
}
}

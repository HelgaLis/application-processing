package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import repository.ApplicationRepository;
import repository.ApplicationRepositoryImpl;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {
	@Bean
	public ApplicationRepository applicationRepository() {
		return new ApplicationRepositoryImpl(sessionFactory().getObject());
	}
	@Bean
	public PlatformTransactionManager transactionalManager(){
		HibernateTransactionManager transactionalManager = new HibernateTransactionManager();
		 transactionalManager.setSessionFactory(sessionFactory().getObject());
		 return transactionalManager;
		 
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSFBean = new LocalSessionFactoryBean();
		localSFBean.setAnnotatedClasses(model.BaseApplication.class, model.SignedApplication.class, model.ClaimApplication.class);
		localSFBean.setHibernateProperties(hibernateProperties());
		localSFBean.setDataSource(dataSource());
		return localSFBean;
	}
	@Bean
	public DataSource dataSource() {
    	BasicDataSource basicDataSource = new BasicDataSource();
    	basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	basicDataSource.setUrl("jdbc:mysql://localhost:3306/app1");
    	basicDataSource.setUsername("root");
    	basicDataSource.setPassword("root");
		return basicDataSource;
		
	}
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.DIALECT, org.hibernate.dialect.MySQL55Dialect.class.getName());
        properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        return properties;
	}
}

package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class PersistenceConfiguration {
	@Bean
	public HibernateTransactionManager hibernateTransactionalManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
	@Bean
	public LocalSessionFactoryBean SessionFactory() {
		LocalSessionFactoryBean localSFBean = new LocalSessionFactoryBean();
		localSFBean.setAnnotatedPackages("model");
		localSFBean.setHibernateProperties(hibernateProperties());
		localSFBean.setDataSource(dataSource());
		return localSFBean;
	}
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder dbBuilde = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = dbBuilde.setType(EmbeddedDatabaseType.HSQL).setName("applications").build();
		return db;
		
	}
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.DIALECT, org.hibernate.dialect.HSQLDialect.class.getName());
        properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        return properties;
	}
}

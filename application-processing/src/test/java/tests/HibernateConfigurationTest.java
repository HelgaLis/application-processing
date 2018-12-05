package tests;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import configuration.PersistenceConfiguration;
import model.BaseApplication;


public class HibernateConfigurationTest {
	private static ApplicationContext context;
	private static SessionFactory sessionFactory;
	static {
		context = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
		sessionFactory = context.getBean(SessionFactory.class);
	}
	
	@Test
	@Transactional
	public void test() {
		System.out.println("Started persistence tests");
		Session session = sessionFactory.openSession();
		session.get(BaseApplication.class, 0l);
	}
}

package tests;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.PersistenceConfiguration;
import model.ClaimApplication;
import model.SignedApplication;
import repository.ApplicationRepository;


public class HibernateConfigurationTest {
	private static ApplicationContext context;
	private static ApplicationRepository applicationRepository;
	static {
		context = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
		applicationRepository = context.getBean(ApplicationRepository.class);
	}
	
	@Test
	public void saveApplication() {
		ClaimApplication claimApp = new ClaimApplication();
		claimApp.setId(100l);
		claimApp.setTitle("I am first");
		claimApp.setDescription("You are last all");
		applicationRepository.saveApplication(claimApp);
		SignedApplication signedApp = new SignedApplication();
		signedApp.setId(101l);
		signedApp.setAuthorName("Roro");
		applicationRepository.saveApplication(signedApp);
	}
	@Test
	public void getApplication() {
		System.out.println(applicationRepository.getApplicationById(100l));
		System.out.println(applicationRepository.getApplicationById(101l));
	}
}

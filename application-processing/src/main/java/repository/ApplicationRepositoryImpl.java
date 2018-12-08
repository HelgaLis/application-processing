package repository;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exeption.ProcessedApplicationNotFoundException;
import model.BaseApplication;
@Repository
@Transactional
public class ApplicationRepositoryImpl implements ApplicationRepository {
	private final SessionFactory sessionFactory;
	@Autowired
	public ApplicationRepositoryImpl(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	@Override
	public void saveApplication(BaseApplication app){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(app);
		}
		catch(DataIntegrityViolationException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public BaseApplication getApplicationById(long id) {
		Session session = sessionFactory.getCurrentSession();
		BaseApplication app = session.get(BaseApplication.class, id);
		if(app==null)
			throw new ProcessedApplicationNotFoundException(id);
		return session.get(BaseApplication.class, id);
	}

}

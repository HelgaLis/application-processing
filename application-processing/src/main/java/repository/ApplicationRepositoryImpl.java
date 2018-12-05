package repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.BaseApplication;
@Repository
@Transactional
public class ApplicationRepositoryImpl implements ApplicationRepository {

	@Override
	public void saveApplication(BaseApplication app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public BaseApplication getApplicationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

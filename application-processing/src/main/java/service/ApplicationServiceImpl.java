package service;

import org.springframework.beans.factory.annotation.Autowired;

import model.BaseApplication;
import repository.ApplicationRepository;

public class ApplicationServiceImpl implements ApplicationService {
	private final ApplicationRepository repository;
	
	@Autowired
	public ApplicationServiceImpl(ApplicationRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveApplication(BaseApplication app) {
		repository.saveApplication(app);

	}

	@Override
	public BaseApplication getApplicationById(long id) {
		return repository.getApplicationById(id);
	}

}

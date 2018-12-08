package service;


import model.BaseApplication;

public interface ApplicationService {
	public void saveApplication(BaseApplication app);
	public BaseApplication getApplicationById(long id);
}

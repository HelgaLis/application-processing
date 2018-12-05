package repository;

import model.BaseApplication;

public interface ApplicationRepository {
	public void saveApplication(BaseApplication app);
	public BaseApplication getApplicationById(long id);
}

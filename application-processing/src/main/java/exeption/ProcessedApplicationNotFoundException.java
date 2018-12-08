package exeption;

public class ProcessedApplicationNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -6890407909844339683L;
	long appId;
	public ProcessedApplicationNotFoundException(long appId) {
		super();
		this.appId = appId;
	}
	public long getAppId() {
		return appId;
	}	
}

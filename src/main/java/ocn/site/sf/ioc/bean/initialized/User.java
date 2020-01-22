package ocn.site.sf.ioc.bean.initialized;

public class User {

	public User() {
		super();
	}

	public static User getInstance() {
		return new User();
	}

	public User getUser() {
		return this;
	}

}

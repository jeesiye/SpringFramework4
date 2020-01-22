package ocn.site.sf.ioc.bean.lookup.interfs;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements ApplicationContextAware {
	private ApplicationContext ac;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ac = applicationContext;
	}

	@SuppressWarnings("unused")
	private Person person;

	public Person getPerson() {
		return this.ac.getBean(Person.class);
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}

package ocn.site.sf.aop.spring.introduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconfig.class)
public class Javatest {

	private @Autowired ProxyFactory proxyFactory;
	private @Autowired User user;
	private @Autowired DelegatingIntroductionInterceptorImpl interceptorImpl;

	@Test
	public void run() throws Exception {
		proxyFactory.setTarget(user);
		proxyFactory.addAdvice(interceptorImpl);
		User user = (User) proxyFactory.getProxy();
		user.work();
		Person person = (Person) user;
		person.eat();
	}

}

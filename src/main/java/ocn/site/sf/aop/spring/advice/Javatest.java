package ocn.site.sf.aop.spring.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Appconfig.class)
public class Javatest {
	
	private @Autowired ProxyFactory proxyFactory;
	private @Autowired User target;
	private @Autowired MethodBeforeAdviceImpl beforeAdviceImpl;
	private @Autowired AfterReturningAdviceImpl returningAdviceImpl;
	private @Autowired ThrowsAdviceImpl throwsAdviceImpl;
	private @Autowired MethodInterceptorImpl aroundAdviceImpl;

	@Test
	public void beforeAdvice() throws Exception {
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(beforeAdviceImpl);
		User user = (User) proxyFactory.getProxy();
		user.work();
	}

	@Test
	public void returnAdvice() throws Exception {
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(returningAdviceImpl);
		User user = (User) proxyFactory.getProxy();
		user.work();
	}

	@Test
	public void throwsAdvice() throws Exception {
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(throwsAdviceImpl);
		User user = (User) proxyFactory.getProxy();
		user.throwException();
	}

	@Test
	public void aroundAdvice() throws Exception {
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(aroundAdviceImpl);
		User user = (User) proxyFactory.getProxy();
		user.work();
	}

}

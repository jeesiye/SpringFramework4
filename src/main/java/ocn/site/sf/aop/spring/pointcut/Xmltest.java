package ocn.site.sf.aop.spring.pointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/aop/spring/pointcut/app.xml")
public class Xmltest {

	private @Autowired ProxyFactoryBean factoryBean;
	private @Autowired AspectJExpressionPointcut pointcut;
	private @Autowired DefaultPointcutAdvisor advisor;

	private @Autowired User user;
	private @Autowired MethodBeforeAdviceImpl beforeAdviceImpl;

	@Test
	public void run() throws Exception {
		pointcut.setExpression("execution(public void ocn.site.sf.aop.spring.pointcut.User.work())");
		advisor.setPointcut(pointcut);
		advisor.setAdvice(beforeAdviceImpl);

		factoryBean.setTarget(user);
		factoryBean.addAdvisor(advisor);

		User user = (User) factoryBean.getObject();
		user.work();
		user.eat();

	}

}

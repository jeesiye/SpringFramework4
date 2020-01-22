package ocn.site.sf.aop.spring.pointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ocn.site.sf.aop.spring.pointcut")
public class Appconfig {

	@Bean
	public ProxyFactoryBean getProxyFactoryBean() {
		ProxyFactoryBean factoryBean = new ProxyFactoryBean();
		factoryBean.setProxyTargetClass(true);
		return factoryBean;
	}

	@Bean
	public Pointcut getPointcut() {
		return new AspectJExpressionPointcut();
	}

	@Bean
	public PointcutAdvisor getPointcutAdvisor() {
		return new DefaultPointcutAdvisor();
	}

}

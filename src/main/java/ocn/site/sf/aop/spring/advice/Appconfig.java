package ocn.site.sf.aop.spring.advice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.spring.advice")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

	@Bean
	public ProxyFactory getProxyFactory() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setProxyTargetClass(true);
		return proxyFactory;
	}

}

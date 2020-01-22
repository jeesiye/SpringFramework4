package ocn.site.sf.aop.spring.introduce;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ocn.site.sf.aop.spring.introduce")
public class Appconfig {

	@Bean
	public ProxyFactory getProxyFactory() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setProxyTargetClass(true);
		return proxyFactory;
	}

}

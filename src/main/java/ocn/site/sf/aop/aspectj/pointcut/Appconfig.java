package ocn.site.sf.aop.aspectj.pointcut;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.aspectj.pointcut")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}

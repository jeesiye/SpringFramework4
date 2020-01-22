package ocn.site.sf.aop.pcd.execution;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.pcd.execution")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}

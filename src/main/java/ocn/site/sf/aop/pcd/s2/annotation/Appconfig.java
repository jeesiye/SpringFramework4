package ocn.site.sf.aop.pcd.s2.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.pcd.s2.annotation")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}

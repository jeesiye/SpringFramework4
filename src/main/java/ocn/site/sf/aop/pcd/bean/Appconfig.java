package ocn.site.sf.aop.pcd.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.pcd.bean")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}

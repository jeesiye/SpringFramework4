package ocn.site.sf.aop.pcd.args;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ocn.site.sf.aop.pcd.args")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}

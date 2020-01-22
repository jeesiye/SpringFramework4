package ocn.site.sf.ioc.annotation.PropertySource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//注解 @PropertySource
//可在 java-config 或 anno-config 风格的配置中,便捷的导入属性文件.
@Configuration
@PropertySource("classpath:ocn/site/sf/ioc/annotation/PropertySource/config.properties")
@ComponentScan("ocn.site.sf.ioc.annotation.PropertySource")
public class Appconfig {

}

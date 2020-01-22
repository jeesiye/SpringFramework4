package ocn.site.sf.ioc.annotation.Scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//配置bean的作用域，基于核心的模块中只有单例和多例的区别。
//具体的查看doc文档，讲解的很详细。
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {

}

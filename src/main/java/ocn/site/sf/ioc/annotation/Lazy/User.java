package ocn.site.sf.ioc.annotation.Lazy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//使用 @Lazy 注解标记的bean,表示只有在使用的时候才会被实例化
//而不是spring的默认加载机制,在容器初始化的时候,就实例化所注册的bean组件
@Component
@Lazy
public class User implements InitializingBean {
	private final static Logger log = LogManager.getLogger();

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("bean start initializing");
	}

}

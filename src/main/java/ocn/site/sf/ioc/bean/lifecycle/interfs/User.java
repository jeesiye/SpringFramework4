package ocn.site.sf.ioc.bean.lifecycle.interfs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User implements InitializingBean, DisposableBean {
	private final static Logger log = LogManager.getLogger();

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("initialized");
	}

	@Override
	public void destroy() throws Exception {
		log.info("destroy");
	}

}

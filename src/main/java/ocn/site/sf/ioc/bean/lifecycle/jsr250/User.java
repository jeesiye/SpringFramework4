package ocn.site.sf.ioc.bean.lifecycle.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {

	private final static Logger log = LogManager.getLogger();

	@PreDestroy
	public void destroy() {
		log.info("destroy");
	}

	@PostConstruct
	public void initialized() {
		log.info("initialized");
	}

}

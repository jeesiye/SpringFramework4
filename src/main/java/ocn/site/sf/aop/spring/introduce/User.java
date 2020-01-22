package ocn.site.sf.aop.spring.introduce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {

	private final Logger logger = LogManager.getLogger();

	public void work() {
		logger.info("工作任务");
	}

}
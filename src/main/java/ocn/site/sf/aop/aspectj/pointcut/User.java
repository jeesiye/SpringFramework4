package ocn.site.sf.aop.aspectj.pointcut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {

	private final Logger logger = LogManager.getLogger();

	public void work(int id) {
		logger.info("工作任务");
	}

	public void eat() {
		logger.info("补充能量");
	}

}
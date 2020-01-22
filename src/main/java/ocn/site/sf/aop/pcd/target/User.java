package ocn.site.sf.aop.pcd.target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Custanno
@Component
public class User {

	private final Logger logger = LogManager.getLogger();

	public void work() {
		logger.info("工作任务");
	}

	public void eat() {
		logger.info("补充能量");
	}

}

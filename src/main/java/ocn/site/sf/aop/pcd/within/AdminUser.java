package ocn.site.sf.aop.pcd.within;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AdminUser extends User {

	private final Logger logger = LogManager.getLogger();

	public void manager() {
		logger.info("管理任务");
	}

}
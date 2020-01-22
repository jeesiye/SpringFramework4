package ocn.site.sf.aop.pcd.args;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {

	private final Logger logger = LogManager.getLogger();

	public void work(int id) {
		logger.info("工作任务");
	}

	public void eat(Param param) {
		logger.info("补充能量");
	}

	public void addWork(ParamImpl param) {
		logger.info("添加工作");
	}

}
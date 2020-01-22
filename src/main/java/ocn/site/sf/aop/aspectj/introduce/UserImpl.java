package ocn.site.sf.aop.aspectj.introduce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements User {

	private final static Logger log = LogManager.getLogger();

	@Override
	public void work() {
		// TODO Auto-generated method stub
		log.info("工作任务。");
	}

}

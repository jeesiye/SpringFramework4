package ocn.site.sf.aop.spring.introduce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class DelegatingIntroductionInterceptorImpl extends DelegatingIntroductionInterceptor implements Person {

	private static final long serialVersionUID = 9024298610315220433L;
	private final static Logger logger = LogManager.getLogger();

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		logger.info("补充能量");
	}

}

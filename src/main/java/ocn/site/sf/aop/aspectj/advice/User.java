package ocn.site.sf.aop.aspectj.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {

	private final Logger logger = LogManager.getLogger();
	private final Class<?>[] nullcls = new Class<?>[] {};

	public void handlerBefore() throws Exception {
		logger.info(this.getClass().getMethod("handlerBefore", nullcls));
	}

	public void handlerAfter() throws Exception {
		logger.info(this.getClass().getMethod("handlerAfter", nullcls));
	}

	public String handlerReturning() throws Exception {
		logger.info(this.getClass().getMethod("handlerReturning", nullcls));
		return "0";
	}

	public void handlerThrowing() throws Exception {
		logger.info(this.getClass().getMethod("handlerThrowing", nullcls));
		throw new NullPointerException();
	}

	public void handlerAround() throws Exception {
		logger.info(this.getClass().getMethod("handlerAround", nullcls));
	}

}

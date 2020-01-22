package ocn.site.sf.aop.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MethodInterceptorImpl implements MethodInterceptor {

	private final Logger logger = LogManager.getLogger();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		logger.info("start method");
		Object value = invocation.proceed();
		logger.info("ending method");
		return value;
	}

}

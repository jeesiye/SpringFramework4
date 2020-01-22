package ocn.site.sf.aop.spring.pointcut;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	private final static Logger logger = LogManager.getLogger();

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("before advice");
	}

}

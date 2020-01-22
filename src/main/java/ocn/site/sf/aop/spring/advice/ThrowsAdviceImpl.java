package ocn.site.sf.aop.spring.advice;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

//异常通知推荐使用的接口，注意此接口是个标记接口。
@Component
public class ThrowsAdviceImpl implements ThrowsAdvice {

	private final Logger logger = LogManager.getLogger();

	// method defined reference superclass doc
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		logger.info(ex.toString());
		logger.info("exception advice");
	}

}

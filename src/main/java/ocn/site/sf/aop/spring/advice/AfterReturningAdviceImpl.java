package ocn.site.sf.aop.spring.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

//后置通知推荐实现的接口，具体可参考 Advice AfterAdvice 接口的规范
@Component
public class AfterReturningAdviceImpl implements AfterReturningAdvice {

	private final Logger logger = LogManager.getLogger();

	// 在spring中默认是没有后置通知和后置返回通知，两者的通知是在一起同时发生的。
	// 若要使用细化的功能，可以实现 AfterAdvice 接口进行自定义的功能扩展。
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info(returnValue.toString());
		logger.info(method.toString());
		logger.info(Arrays.toString(args));
		logger.info(target.toString());
		logger.info("return advice");
	}

}

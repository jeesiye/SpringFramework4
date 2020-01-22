package ocn.site.sf.aop.spring.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

//主要参考 Advice 接口
//此测试的是基于spring的 aop的实现
//
//在advice通知的方面,这些通知的实现,都会切入目标类的所有方法.
//
//5种通知方式需要实现的约定接口
//\____ org.springframework.aop.MethodBeforeAdvice
//\____ org.springframework.aop.AfterReturningAdvice
//\____ org.springframework.aop.ThrowsAdvice
//\____ org.aopalliance.intercept.MethodInterceptor
@Component
public class User {

	private final Logger logger = LogManager.getLogger();

	public int work() {
		logger.info("start work");
		return 0;
	}

	public void throwException() {
		throw new NullPointerException();
	}

}

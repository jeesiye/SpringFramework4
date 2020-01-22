package ocn.site.sf.aop.aspectj.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//测试基于xml-config的风格时，若是标记了该注解@Aspect
//即使是没有开启注解扫描的功能，也会执行两次通知。原因待定。
//在基于java-config风格的配置中，官方文档明确指出，需要标记@Component注解，否则无法正常工作。
//@Aspect // 此注解是java-config声明切面的方式
@SuppressWarnings("unused")
@Component
public class LogUser {

	private final Logger logger = LogManager.getLogger();

	@Before("execution(public void ocn.site.sf.aop.aspectj.advice.User.handlerBefore())")
	public void beforeAdvice() {
		logger.info("before advice");
	}

	@After("execution(public void ocn.site.sf.aop.aspectj.advice.User.handlerAfter())")
	public void afterAdvice() {
		logger.info("after advice");
	}

	@AfterReturning(pointcut = "execution(public * ocn.site.sf.aop.aspectj.advice.User.handlerReturning())", returning = "value")
	public void returningAdvice(String value) {
		logger.info("returning advice ===>>" + value);
	}

	@AfterThrowing(pointcut = "execution(public void ocn.site.sf.aop.aspectj.advice.User.handlerThrowing())", throwing = "ex")
	public void throwingAdvice(Exception ex) {
		logger.info("throwing advice ===>>" + ex.toString());
	}

	@Around("execution(public void ocn.site.sf.aop.aspectj.advice.User.handlerAround())")
	public void aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		logger.info("handler start");
		joinpoint.proceed();
		logger.info("handler ending");
	}
}
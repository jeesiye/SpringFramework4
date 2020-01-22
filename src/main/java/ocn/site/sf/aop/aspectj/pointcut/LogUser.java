package ocn.site.sf.aop.aspectj.pointcut;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect // java-config配置的时候开启此注解
@SuppressWarnings("unused")
@Component
public class LogUser {

	private final Logger logger = LogManager.getLogger();

	@Pointcut("execution(* ocn.site.sf.aop.aspectj.pointcut.User.*(..))")
	public void definePointcut() {

	}

	@Before(value = "definePointcut())")
	public void beforeAdvice() {
		logger.info("before advice");
	}
//	@Before(value = "definePointcut() and args(id)")
//	public void beforeAdvice(int id) {
//		logger.info("before advice ===>>" + id);
//	}

	@After("definePointcut()")
	public void afterAdvice() {
		logger.info("after advice");
	}

}

package ocn.site.sf.aop.pcd.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//说明，摘录的英文说明文档皆出自spring的官方文档。
//@Aspect
@SuppressWarnings("unused")
@Component
public class LogUser {

//	Other pointcut types
//	The full AspectJ pointcut language supports additional pointcut designators that are not supported
//	in Spring. These are: call, get, set, preinitialization, staticinitialization,
//	initialization, handler, adviceexecution, withincode, cflow, cflowbelow,
//	if, @this, and @withincode. Use of these pointcut designators in pointcut expressions
//	interpreted by Spring AOP will result in an IllegalArgumentException being thrown.
//	The set of pointcut designators supported by Spring AOP may be extended in future releases to
//	support more of the AspectJ pointcut designators.

	// 多个pcd可以使用 && || ！ 进行组合限制匹配

	private final Logger logger = LogManager.getLogger();

	// bean(idOrNameOfBean) ： 对匹配bean的所有方法执行织入
	// 注意，bean仅仅在springaop受到支持。
	// 它仅仅是aspectj标准pcd对spring的扩展，在aspectj中是不支持的。
	private final String execution = "bean(user)";

	@Before(value = execution)
	public void beforeAdvice() {
		logger.info("before advice");
	}

}
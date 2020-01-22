package ocn.site.sf.aop.pcd.target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
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

	// target(M) : 对匹配M类型（包含子类）的所有方法执行连接点（仅支持通配符+）
	// @target(M) : 对标准M注解的类的所有方法执行连接点（不支持通配符）
	// target(M)和this(M)大多数情况下无区别，但是在introduce功能方面，
	// target是不支持继承匹配的，而this是支持继承匹配的（限定顶层接口时）。
	// 在当前测试的环境下时，target(M)是支持继承匹配的。
	private final String targetExp = "target(ocn.site.sf.aop.pcd.target.User)";
	private final String annoTargetExp = "@target(ocn.site.sf.aop.pcd.target.Custanno)";

	@Before(targetExp)
	public void beforeAdvice() {
		logger.info("before advice");
	}

	@After(annoTargetExp)
	public void afterAdvice() {
		logger.info("after advice");
	}
}
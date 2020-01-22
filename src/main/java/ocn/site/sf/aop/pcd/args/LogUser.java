package ocn.site.sf.aop.pcd.args;

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

	// args(M) : 对匹配参数M类型的方法执行连接点（支持通配符）
	// @agrs(M) : 对匹配标注M注解的参数类型的方法执行连接点 （不支持通配符）
	// \___________: 生效范围具有传递继承性。
	private final String argsExp = "args(int)";
	private final String annoArgsExp = "@args(ocn.site.sf.aop.pcd.args.Custanno)";

	@Before(argsExp)
	public void beforeAdvice() {
		logger.info("before advice");
	}

	@After(annoArgsExp)
	public void afterAdvice() {
		logger.info("after advice");
	}
}

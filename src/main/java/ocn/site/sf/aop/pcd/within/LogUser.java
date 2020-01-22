package ocn.site.sf.aop.pcd.within;

import java.lang.annotation.Inherited;

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

	// @target(M)和@within(M)的区别。
//	前者不支持继承，后者支持继承，此观点是某些参考书上指出的。但是实际测试并非如此。
//	实际测试中，是否支持继承，取决于注解中是否标注了@Inherited注解。
//	参考书说的是否正确，有待考究。
//	参考书是：精通spring4企业应用开发实战。

	private final Logger logger = LogManager.getLogger();

	// within(M) : 对匹配M类的所有方法执行连接点（支持通配符）
	private final String withinExp = "within(ocn.site.sf.aop.pcd.within.User)";
	// @within(M) : 对匹配M类注解（类级别）的类对象及其子类的所有方法执行连接点（不支持通配符）
	// \___________: 当然前提是该注解支持自动继承！
	// \___________: 有些书籍指出不支持针对接口的继承，仅作了解。
	private final String annoWithinExp = "@within(ocn.site.sf.aop.pcd.within.Custanno)";

	@Before(withinExp)
	public void beforeAdvice() {
		logger.info("before advice");
	}

	@After(annoWithinExp)
	public void afterAdvice() {
		logger.info("after advice");
	}
}

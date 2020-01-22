package ocn.site.sf.aop.pcd.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//说明，摘录的英文说明文档皆出自spring的官方文档。
@SuppressWarnings("unused")
//@Aspect
@Component
public class LogUser {

//	Other pointcut types
//	The full AspectJ pointcut language supports additional pointcut designators that are not supported
//	in Spring. These are: call, get, set, preinitialization, staticinitialization,
//	initialization, handler, adviceexecution, withincode, cflow, cflowbelow,
//	if, @this, and @within code. Use of these pointcut designators in pointcut expressions
//	interpreted by Spring AOP will result in an IllegalArgumentException being thrown.
//	The set of pointcut designators supported by Spring AOP may be extended in future releases to
//	support more of the AspectJ pointcut designators.

	// 多个pcd可以使用 && || ！ 进行组合限制匹配

	private final Logger logger = LogManager.getLogger();

//	execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
	// execution(pattern-expression) : 对匹配的方法执行连接点
	// 以上所有正则表达式模块部分都支持通配符号 * ，在declaring-type-pattern中，应当正确且必须的使用符号.表示层级包
	// 在param-pattern中，(..)表示匹配任意方法不限制参数列表，(*)表示限制参数列表只能有一个任意类型参数，()表示参数列表必须为空才会匹配
	// 以下示例摘自官方文档举例
	// execution(public * *(..)) : 匹配所有public修饰的方法
	// execution(* set*(..)) : 匹配所有以set开头的方法
	// execution(* ocn.site.springaop.target.User.*(..)) : 匹配指定包中User类的所有方法
	// execution(* ocn.site.springaop.target.*.*(..)) : 匹配指定包target包中所有类的所有方法
	// execution(* ocn..*.*(..)) : 匹配ocn包包含子包中的所有类的所有方法
	//

	private final String expression = "execution(public void ocn.site.sf.aop.pcd.execution.User.work(int)) && args(id)";
//	private final String expression = "execution(* ocn..*.*(..)) && args(id)";

	@Before(value = expression)
	public void beforeAdvice(int id) {
		logger.info("before advice ===>" + id);
	}

}

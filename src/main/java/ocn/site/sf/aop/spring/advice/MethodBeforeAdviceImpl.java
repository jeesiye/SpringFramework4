package ocn.site.sf.aop.spring.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

//前置通知推荐实现的接口，具体参考 Advice BeforeAdvice 的组织结构。
@Component
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	private final Logger logger = LogManager.getLogger();

	// 接口参数的说明。
	// method 表示当前拦截的方法对象。
	// args 表示当前拦截的方法参数数组对象。
	// target 表示当前拦截的方法所属的类对象实例。
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info(method.toString());
		logger.info(Arrays.toString(args));
		logger.info(target.toString());
		logger.info("before advice");
	}

}

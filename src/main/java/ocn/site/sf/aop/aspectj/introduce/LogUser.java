package ocn.site.sf.aop.aspectj.introduce;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

//@Aspect // java-config配置的时候开启此注解
@SuppressWarnings("unused")
@Component
public class LogUser {

	// 引入通知是aop中的一种技术实现，在实际使用中个人感觉很少使用。
	// 此举仅作学习了解。

//	@DeclareParents 向目标类,引入指定接口的实现
//	value : 指定目标类,符号+表示接口的所有实现类
//	defaultImpl : 引入指定接口的实现类
//
//	补充:测试环境中使用面向接口编程特性.
	@DeclareParents(value = "ocn.site.sf.aop.aspectj.introduce.User+", defaultImpl = PersonImpl.class)
	public Person person;

}
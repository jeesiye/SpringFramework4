package ocn.site.sf.ioc.annotation.Lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class User {

	private Person person;

//	方法注入的使用场景
//	\_____当A依赖B时,对于A的实例,每次获取B的实例的时候
//	\_____预期结果是,获取的B的实例都是不同状态的
//	\_____此时方法注入的机制可实现这点
//
//	这种方式,比之每次获取A的新实例的方式要好的多.
//	在设计模式方面,属于 创建型模式

	// 如不添加该注解，即使Person配置的是多例模式的，每次调用这个方法返回的还是同一个实例。
	// 具体原因是，因为在容器中User的初始化只有一次，这包括他的属性和状态。
	// 若是想调用不同实例的依赖项目，就需要使用到方法注入的功能了。
	@Lookup
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "User [person=" + person + "]";
	}

}

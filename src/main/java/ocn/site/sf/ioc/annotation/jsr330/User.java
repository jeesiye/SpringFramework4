package ocn.site.sf.ioc.annotation.jsr330;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class User {

	// JSR330 注解
	// @Inject 等价于 @Autowired 或者 @Resource
	// @Named 用在属性上,等价于 spring内置注解 @Qualifier 使用在类级别上等价于注解 @Component
	// @Singleton 注解表示该组件是单例的 此注解在spring机制中，个人感觉是多此一举。

	private @Inject @Named("person") Person person;

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

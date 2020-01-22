package ocn.site.sf.ioc.annotation.DependsOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

//等价于 bean元素的 depend-on属性
//
//对于 A依赖于B,C依赖于B,但是A与C之间的依赖关系不是很明显.
//可是A的实例化,需要C的实例化.
//此时可使用强制依赖的注解标记.
//在实例化A的时候,强制实例化C
@Component
@DependsOn("personInit")
public class User {

	private @Autowired Person person;

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

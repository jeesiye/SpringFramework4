package ocn.site.sf.ioc.annotation.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

	// 该注解依据bean的名称，对依赖注入作进一步的限定
	// 类似于自动装配中的 byName 设定。
	private @Autowired @Qualifier("person") Person person;

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

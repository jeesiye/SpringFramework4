package ocn.site.sf.ioc.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class User {

	// 该注解类似xml配置中的自动装配
	// 但是个人认为也是有所区别的
	// 具体原因暂定。
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

package ocn.site.sf.ioc.annotation.DependsOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("personInit")
@Lazy
public class PersonInit {

	private Person person;

	public Person getPerson() {
		return person;
	}

	// 该注解必须标注在setter方法上，否则不会生效配置。
	@Autowired
	public void setPerson(Person person) {
		person.setId(34);
		this.person = person;
	}

	@Override
	public String toString() {
		return "PersonInit [person=" + person + "]";
	}

}

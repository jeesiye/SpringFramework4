package ocn.site.sf.ioc.annotation.Required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class User {

	private Person person;

	public Person getPerson() {
		return person;
	}

//	使用此注解是多此一举的！
//	此注解标记无实际意义
//	注解 Autowired 的默认值完全可以取代
//	表示,此依赖项是必须被注入的.
//	注意 : 必须和 Autowired 同处使用.
// 该注解属性中的默认具有同等的效果。
	@Autowired
	@Required
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "User [person=" + person + "]";
	}

}

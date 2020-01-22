package ocn.site.sf.ioc.annotation.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

	// 容器在启动的时候，会默认注册一套spel的解析器，可以结合该注解来直接只用该表达式。
	private @Value("#{'hack'}") String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

}

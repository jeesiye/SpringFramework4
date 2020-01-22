package ocn.site.sf.ioc.annotation.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class User {
	private final static Logger log = LogManager.getLogger();

	// JSR250的三个注解
	// @PostConstruct ： 标注bean的初始化工作函数
	// @PreDestroy ： 标注bean的销毁工作函数
	// @Resource ： 大多数情况下等价于spring内置的注解@Autowired

	private @Resource Person person;

	@PostConstruct
	public void initialized() {
		log.info("bean start initializing");
	}

	@PreDestroy
	public void destroy() {
		log.info("bean is died");
	}

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

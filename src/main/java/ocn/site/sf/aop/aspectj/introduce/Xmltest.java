package ocn.site.sf.aop.aspectj.introduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//注意测试xml的配置的时候，应当将切面中的注解@Aspect给注释掉！！！
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/aop/aspectj/introduce/app.xml")
public class Xmltest {

	private @Autowired User user;

	@Test
	public void run() throws Exception {
		user.work();
		Person person = (Person) user;
		person.eat();
	}

}

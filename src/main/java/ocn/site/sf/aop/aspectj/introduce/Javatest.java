package ocn.site.sf.aop.aspectj.introduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconfig.class)
public class Javatest {
	private @Autowired User user;

	@Test
	public void run() throws Exception {
		user.work();
		Person person = (Person) user;
		person.eat();
	}
}

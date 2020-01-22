package ocn.site.sf.aop.aspectj.pointcut;

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
		user.eat();
		user.work(34);
	}

}

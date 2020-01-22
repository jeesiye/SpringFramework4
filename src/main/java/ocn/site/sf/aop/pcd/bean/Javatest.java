package ocn.site.sf.aop.pcd.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconfig.class)
public class Javatest {

	private @Autowired User user;

	@Test
	public void run() throws Exception {
		user.work();
		user.eat();
	}

}

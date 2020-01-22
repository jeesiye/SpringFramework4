package ocn.site.sf.aop.pcd.execution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/aop/pcd/execution/app.xml")
public class Xmltest {

	private @Autowired User user;

	@Test
	public void run() throws Exception {
		user.work(34);
		user.eat();
	}

}

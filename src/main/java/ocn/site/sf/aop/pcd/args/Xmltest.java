package ocn.site.sf.aop.pcd.args;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/aop/pcd/args/app.xml")
public class Xmltest {

	private @Autowired User user;
	private @Autowired Param param;
	private @Autowired ParamImpl paramImpl;

	@Test
	public void run() throws Exception {
		user.work(34);
		user.addWork(paramImpl);
		user.eat(param);
	}

}

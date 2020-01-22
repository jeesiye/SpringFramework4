package ocn.site.sf.aop.pcd.target;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// 在进行xml配置的测试的时候，应当把切面类的注解@Aspect给注释掉。
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/aop/pcd/target/app.xml")
public class Xmltest {

	private @Autowired User user;
	private @Autowired AdminUser adminUser;

	@Test
	public void run() throws Exception {
		user.work();
		user.eat();
		adminUser.manager();
	}

}

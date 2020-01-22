package ocn.site.sf.ioc.bean.lifecycle.jsr250;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/ioc/bean/lifecycle/jsr250/app.xml")
public class Runtest {
	private final static Logger log = LogManager.getLogger();

	@Resource
	private ApplicationContext ac;

	@Test
	public void run() {
		User obj = ac.getBean(User.class);
		log.info(obj);
	}

}

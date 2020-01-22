package ocn.site.sf.ioc.bean.initialized;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/ioc/bean/initialized/app.xml")
public class Runtest {

	private final static Logger log = LogManager.getLogger();
	private @Autowired ApplicationContext ac;

	@Test
	public void run() {
		User obj1 = ac.getBean("obj1", User.class);
		log.info(obj1);
		User obj2 = ac.getBean("obj2", User.class);
		log.info(obj2);
		User obj3 = ac.getBean("obj3", User.class);
		log.info(obj3);
	}

}

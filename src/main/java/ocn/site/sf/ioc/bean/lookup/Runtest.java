package ocn.site.sf.ioc.bean.lookup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/ioc/bean/lookup/app.xml")
public class Runtest {

	private final static Logger log = LogManager.getLogger();
	private @Autowired ApplicationContext ac;

	@Test
	public void run() {
		User obj = ac.getBean(User.class);
		log.info(obj.getPerson());
		log.info(obj.getPerson());
	}

}

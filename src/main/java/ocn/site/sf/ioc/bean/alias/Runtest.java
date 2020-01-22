package ocn.site.sf.ioc.bean.alias;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/ioc/bean/alias/app.xml")
public class Runtest {

	private final static Logger log = LogManager.getLogger();
	private @Autowired GenericApplicationContext context;

	@Test
	public void run() throws Exception {
		Person aperson = (Person) context.getBean("a");
		log.info(aperson);
		Person bperson = (Person) context.getBean("user");
		log.info(bperson);
		Person cperson = (Person) context.getBean("ac");
		log.info(cperson);
		context.close();
	}

}

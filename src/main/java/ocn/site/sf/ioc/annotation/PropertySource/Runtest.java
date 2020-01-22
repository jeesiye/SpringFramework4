package ocn.site.sf.ioc.annotation.PropertySource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconfig.class)
public class Runtest {

	private final static Logger log = LogManager.getLogger();
	private @Autowired GenericApplicationContext context;

	@Test
	public void run() throws Exception {
		User user = context.getBean(User.class);
		log.info(user);
		context.close();
	}
}

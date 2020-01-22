package ocn.site.sf.ioc.annotation.jsr330;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Appconfig.class)
public class Runtest {
	private final static Logger log = LogManager.getLogger();
	private @Inject GenericApplicationContext context;

	@Test
	public void run() throws Exception {
		log.info(context.getBean(User.class));
		context.close();
	}

}

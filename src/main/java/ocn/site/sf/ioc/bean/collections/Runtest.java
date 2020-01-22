package ocn.site.sf.ioc.bean.collections;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:ocn/site/sf/ioc/bean/collections/app.xml")
public class Runtest {
	private final static Logger logger = LogManager.getLogger();
	private @Autowired User user;

	@Test
	public void run() throws Exception {
		logger.info(user.getList());
		logger.info(user.getSet());
		logger.info(user.getMap());
		logger.info(user.getProps());
		logger.info(Arrays.toString(user.getArray()));
	}

}

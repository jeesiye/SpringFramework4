package ocn.site.sf.ioc.bean.replacedmethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {

	private final static Logger log = LogManager.getLogger();

	public void work(int id) {
		log.info("user working");
	}

}

package ocn.site.sf.ioc.bean.lifecycle.local;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {

	private final static Logger log = LogManager.getLogger();

	public void init() {
		log.info("init");
	}

	public void distruct() {
		log.info("dist");
	}

}

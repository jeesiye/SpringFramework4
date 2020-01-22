package ocn.site.sf.mvc.exception.mapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public void handler() {
		logger.info("running");
		throw new NullPointerException("test concept SimpleMappingExceptionResolver");
	}

}
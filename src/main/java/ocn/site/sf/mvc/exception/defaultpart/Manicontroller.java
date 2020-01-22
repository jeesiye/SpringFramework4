package ocn.site.sf.mvc.exception.defaultpart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public void handler() throws HttpMediaTypeNotSupportedException {
		logger.info("running");
		// reference DefaultHandlerExceptionResolver
		// org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver.doResolveException(HttpServletRequest,
		// HttpServletResponse, Object, Exception)
		throw new HttpMediaTypeNotSupportedException("test default concept");
	}

}

package ocn.site.sf.mvc.messagesource.httpheader;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public String handler(HttpServletRequest request) {
		RequestContext context = new RequestContext(request);
		logger.info(context.getMessage("key"));
		return "register";
	}

}

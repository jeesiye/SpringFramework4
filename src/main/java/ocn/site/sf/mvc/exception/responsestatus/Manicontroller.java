package ocn.site.sf.mvc.exception.responsestatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// must read doc about `warning`
	@GetMapping("/onmethod")
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "test annotation @ResponseStatus")
	public void handler404() {
		logger.info("used on method success");
	}

	@GetMapping("/onclass")
	public void handler() {
		throw new StatusException();
	}

}
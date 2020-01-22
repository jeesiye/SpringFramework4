package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public void handler(@RequestParam Date param) {
		logger.info(param);
	}

}
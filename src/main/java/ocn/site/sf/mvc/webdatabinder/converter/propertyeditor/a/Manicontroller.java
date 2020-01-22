package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.a;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();
	private @Autowired String2Date string2Date;

	// reference annotation @ControllerAdvice
	// should be read doc @InitBinder
	@InitBinder
	public void postConstructor(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, string2Date);
	}

	@GetMapping("/test")
	public void handler(@RequestParam Date param) {
		logger.info(param);
	}

}

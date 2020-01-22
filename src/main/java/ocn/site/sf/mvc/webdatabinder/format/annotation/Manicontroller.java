package ocn.site.sf.mvc.webdatabinder.format.annotation;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// reference package names : org.springframework.format.annotation
	// should be read doc annotation @EnableWebMvc
	// include @DateTimeFormat @NumberFormat
	@GetMapping("/test")
	public void handler(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date param) {
		logger.info(param);
	}

}
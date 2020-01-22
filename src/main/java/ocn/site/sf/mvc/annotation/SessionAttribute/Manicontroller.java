package ocn.site.sf.mvc.annotation.SessionAttribute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 从session中提取指定的key-value
	@GetMapping("/test")
	public void handler(@SessionAttribute("attr") String value) {
		logger.info(value);
	}

}

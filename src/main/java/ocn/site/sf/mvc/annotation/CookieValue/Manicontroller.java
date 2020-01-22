package ocn.site.sf.mvc.annotation.CookieValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	// 从cookie中读取指定的key-value
	public void handler(@CookieValue("message") String value) {
		logger.info(value);
	}

}
package ocn.site.sf.mvc.annotation.RequestHeader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 从请求的头信息中提取指定的key-value
	@GetMapping("/test")
	public void handler(@RequestHeader(name = HttpHeaders.ACCEPT_LANGUAGE) String value) {
		logger.info(value);
	}

}
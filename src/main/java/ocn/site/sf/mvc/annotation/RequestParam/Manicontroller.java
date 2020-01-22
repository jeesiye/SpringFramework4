package ocn.site.sf.mvc.annotation.RequestParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 从请求路径的参数中提取指定的参数
	@GetMapping("/test")
	public void handler(@RequestParam String param) {
		logger.info(param);
	}
}

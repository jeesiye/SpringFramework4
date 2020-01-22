package ocn.site.sf.mvc.annotation.RequestAttribute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 从http请求对象中提取指定的属性key-value
	@GetMapping("/test")
	public void handler(@RequestAttribute String attr) {
		logger.info(attr);
	}

}
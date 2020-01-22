package ocn.site.sf.mvc.tag.form;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();
	private @Autowired User user;

	// reference annotation @ControllerAdvice
	@ModelAttribute
	public void configinit(ModelMap map) {
		map.addAttribute("user", user);
		logger.info("config success");
	}

	@GetMapping("/test")
	public String handler() {
		return "register";
	}

	@PostMapping("/register")
	public void handlerRegister(User user) {
		logger.info(user);
	}
}
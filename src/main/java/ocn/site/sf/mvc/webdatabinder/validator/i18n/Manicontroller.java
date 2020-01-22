package ocn.site.sf.mvc.webdatabinder.validator.i18n;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();
	private @Autowired User user;
	private final static String NAME_SUCCESS = "success";
	private final static String NAME_REGISTER = "register";

	// reference annotation @ControllerAdvice
	@ModelAttribute
	public void handlerConfig(ModelMap map) {
		map.addAttribute("user", user);
		logger.info("first config success");
	}

	@GetMapping("/test")
	public String handlerPage() {
		return NAME_REGISTER;
	}

	// 注意事项
	// 测试的验证的对象要是javabean
	// BindingResult 对象作为参数，其前面必须是@ModelAttribute注解修饰的对象，否则会报错。
	// An Errors/BindingResult argument is expected to be declared immediately after
	// the model attribute, the @RequestBody or the @RequestPart arguments to which
	// they apply:
	@PostMapping("/register")
	public String handlerRegister(@ModelAttribute @Valid User user, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			logger.info(result.getFieldError().getDefaultMessage());
			return NAME_REGISTER;
		}
		map.put("message", "register success");
		return NAME_SUCCESS;
	}

}
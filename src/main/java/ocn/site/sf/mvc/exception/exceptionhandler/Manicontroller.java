package ocn.site.sf.mvc.exception.exceptionhandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//reference==> /org/springframework/web/servlet/DispatcherServlet.properties

//reference==> org.springframework.web.servlet.DispatcherServlet

//read annotation @EnableWebMvc doc

//reference==> org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.handlerExceptionResolver()

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// reference annotation @ControllerAdvice
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleException(Exception ex) {
		logger.info(ex);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("message", ex);
		return mav;
	}

	@GetMapping("/test")
	public void handler() {
		throw new NullPointerException("test annotation @ExceptionHandler");
	}

}

package ocn.site.sf.mvc.exception.tomcattag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

// 不要忘记配置web.xml文件中的error标签。

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test")
	public void handler() throws ServletException {
		logger.info("running");
		throw new ServletException("test tag of error page");
	}

	@GetMapping("/error")
	public ModelAndView handlerException(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("error");
		// should read ==> org.springframework.web.util.WebUtils
		mav.addObject("status", request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE));// 官方推荐
		mav.addObject("message", request.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE));// 官方推荐
		mav.addObject("exception", request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE));
		return mav;
	}

}

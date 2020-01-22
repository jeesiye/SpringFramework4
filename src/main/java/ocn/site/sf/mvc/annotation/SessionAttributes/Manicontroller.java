package ocn.site.sf.mvc.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//将模型中具体指定名称或之具体相同类型的key-value绑定到httpSession中
//在真实的运行环境中 可使用request或之@SessionAttribute来提取
//在测试环境中 无法测试其真实功效 原因暂定
@Controller
@SessionAttributes(names = { "message" }) // must second used annotation
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 不推荐使用返回具体类型的方式
	// 若是依旧如此 应当使用new来返回对象实例
	@ModelAttribute
	public void configinit(ModelAndView mav) {
		mav.addObject("message", "hack");
//		model.addAttribute("message", "hack");
		logger.info("config success");
	}

	@GetMapping("/test")
	public void handler(HttpServletRequest request, @SessionAttribute("message") String value) {
		logger.info(request.getSession().getAttribute("message"));
		logger.info(value);
	}
}

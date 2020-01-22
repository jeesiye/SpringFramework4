package ocn.site.sf.mvc.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 使用正则表达式要结合路径变量一起使用
	// 使用的语法是 {name:regex expression}
	@RequestMapping("/test/{name:[a-z]+}")
	public void regex(@PathVariable String name) {
		logger.info(name);
	}

	// 支持ant风格的路径设置
	// * 表示任意个字符
	// ** 表示多个路径级别
	// ? 表示任意一个字符
	@RequestMapping("/*.do")
	public void ant() {
		logger.info("handding");
	}

	// 支持逻辑运算符
	@RequestMapping(path = "/test", params = { "name!=jack", "age=32" })
	public void params() {
		logger.info("handler params");
	}

	// 对请求的头信息进行约束
	@RequestMapping(path = "/test", headers = { "content-type=text/html" })
	public void headers() {
		logger.info("handler headers");
	}

	// 对请求方法类型进行约束，注意form表单仅支持get和post类型的请求
	@RequestMapping(path = "/test", method = { RequestMethod.POST })
	public void method() {
		logger.info("handler method");
	}

	// 对请求体的MIME类型进行约束
	@RequestMapping(path = "/test", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public void consumes() {
		logger.info("handler consumes");
	}

	// 对返回体的MIME类型进行约束
	@RequestMapping(path = "/test", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody String produces() {
		logger.info("handler produces");
		return "hack";
	}

}

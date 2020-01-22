package ocn.site.sf.mvc.annotation.PathVariable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 路径变量的使用方式有多种搭配的方式 比如/test1/{var1}/test2/{var2}
	// 若是注册了 HiddenHttpMethodFilter 过滤器 可简单的实现RESTful风格的功能
	// 该注解将路径中的变量绑定到请求方法的参数上
	// 在url中 路径变量的声明使用括号 {} 来完成
	@GetMapping("/test/{var}")
	public void handler(@PathVariable String var) {
		logger.info(var);
	}

}
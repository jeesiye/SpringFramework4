package ocn.site.sf.mvc.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Manicontroller {

	// 注解ModelAttribute的使用方式有4种。
	// 标注在方法级别上的，有3种方式。（若是返回具体的类型，根据个人多次实际测试环境中，对象应当使用new关键字，具体原因暂定。）

	// 标注在参数级别上的，有1种方式。参数级别上的测试，在测试标注在方法级别上都会使用到。
	// 若是标注在参数级别上，效用就是将model模型中的key-value绑定到指定的参数上。
	// 使用时，推荐还是指定name值，进行绑定的。因为测试的时候，不指定会失效。

	private final Logger logger = LogManager.getLogger();

	@ModelAttribute
	public void setModel0(Model model) {
		logger.info("这是标注在方法级别上最为推荐的方式 空返 参数定位Model类型");
		model.addAttribute("key1", "value1");
	}

	@GetMapping("/test0")
	// 此种测试环境，若是不指定name的话，会失效，具体原因不明。
	public void hanlder0(@ModelAttribute("key1") String value) {
		logger.info(value);
	}

	@ModelAttribute
	public List<Integer> setModel1() {
		logger.info("这是标注在方法级别上的第2种方式，没有指定注解的name值，返回具体类型，key为驼峰命名，value为返回值。");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		return list;
	}

	@GetMapping("/test1")
	public void handler1(@ModelAttribute List<Integer> list) {
		logger.info(list);
	}

	@ModelAttribute("key3")
	public String setModel2() {
		logger.info("这是标注在方法级别上的第3种使用方式，指定了注解的name值，返回具体的类型。");
		return new String("value3");
	}

	@GetMapping("/test2")
	public void hanlder2(@ModelAttribute("key3") String value) {
		logger.info(value);
	}

}

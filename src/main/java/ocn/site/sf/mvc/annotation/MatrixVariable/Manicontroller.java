package ocn.site.sf.mvc.annotation.MatrixVariable;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// 矩阵变量的历史
	// 根据RFC3986规定name-value可随着路径片段（path segments）一起出现的规范。
	// spring3.2新增了@MatrixVariable开始支持矩阵变量的部分功能。
	// 从spring4.0开始全面支持该功能。

	// 矩阵变量的使用规范
	// 根据RFC3986的规范，矩阵变量应当绑定在路径变量中！
	// 若是有多个矩阵变量，应当使用英文符号;进行分隔。
	// 若是一个矩阵变量有多个值，应当使用英文符号,进行分隔，或之命名多个重复的key即可。
	// 矩阵变量的值可以存储到 org.springframework.util.MultiValueMap<K, V> 对象中。

	// 矩阵变量默认的配置说明在哪里查看？
	// 查看mvc的语法约束的XSD文档
	// 查看 <mvc:annotation-driven enable-matrix-variables 该属性的doc说明。
	// 在当前测试使用的版本中，矩阵变量的功能默认是关闭的。

	// 如何源码跟踪矩阵变量的默认设置？
	// 1)有此组件进行配置设置矩阵变量的功能是否开启的！
	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.requestMappingHandlerMapping()
	// 2)查看该方法，有两个类对象的配置设置，但是查看该对象定义的布尔类型，无法确定，故跟踪调用该属性的地方。ctrl-alt-h
	// org.springframework.web.servlet.handler.AbstractHandlerMapping.setRemoveSemicolonContent(boolean)
	// 3)阅读该方法的源码，查看是否可确定矩阵变量的默认配置。
	// org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder.StandaloneConfiguration.getHandlerMapping()
	// 4)查看此变量的定义，默认是没有初始化的，即默认值是false的。（追踪到此处未得到结果，回到分岔口重新查看。）
	// org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder.removeSemicolonContent
	// 5)此类的设置方法，在默认情况下是禁用矩阵变量的功能的。
	// org.springframework.web.util.UrlPathHelper.setRemoveSemicolonContent(boolean)
	// org.springframework.web.util.UrlPathHelper.removeSemicolonContent
	// 6)以下指定的方法调用的是UrlPathHelper中的同名方法。
	// org.springframework.web.cors.UrlBasedCorsConfigurationSource.setRemoveSemicolonContent(boolean)
	// 总结：跟随以上的配置流程，就可确定默认的配置情况下，是禁用矩阵变量的功能。

	// 注意！在springmvc中，以及当前版本的默认配置，矩阵变量的功能默认是关闭的。
	// 若是使用矩阵变量的功能，需要手动的开启。
	@GetMapping("/test/{var}")
	public void handler(@PathVariable String var, @MatrixVariable("id") int id,
			@MatrixVariable("list") List<String> list) {
		logger.info(var);
		logger.info(id);
		logger.info(list);
	}

}
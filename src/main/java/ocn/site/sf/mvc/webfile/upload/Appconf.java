package ocn.site.sf.mvc.webfile.upload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ocn.site.sf.mvc.webfile.upload")
public class Appconf extends WebMvcConfigurerAdapter {

	private final static String PREFIX = "/WEB-INF/";
	private final static String SUFFIX = ".jsp";
	private final static String FILEUPLOAD_ENCODING = "utf-8";

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// CommonsMultipartResolver组件的说明
	// 默认情况下,前端控制器是不加载该组件的.故,当使用到spring内嵌支持的下载功能的时候,
	// 需要手动配置该组件.
	// 在配置该组件的时候,需要特别的注意!一定要正确的配置该组件的id
	// 具体原因查看前端控制器中的对应初始化方法.查看initMultipartResolver方法
	// 此处必须指定id的名称 和国际化的处理方式一样
	@Bean(value = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
	public MultipartResolver getMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding(FILEUPLOAD_ENCODING);
		return multipartResolver;
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver(PREFIX, SUFFIX);
	}

}
package ocn.site.sf.mvc.webdatabinder.validator.jsr303.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ocn.site.sf.mvc.webdatabinder.validator.jsr303.basic")
public class Appconf extends WebMvcConfigurerAdapter {

	private final static String PREFIX = "/WEB-INF/";
	private final static String SUFFIX = ".jsp";

	@Bean("paramMap")
	public LinkedMultiValueMap<?, ?> getLinkedMultiValueMap() {
		return new LinkedMultiValueMap<>();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver(PREFIX, SUFFIX);
	}

}
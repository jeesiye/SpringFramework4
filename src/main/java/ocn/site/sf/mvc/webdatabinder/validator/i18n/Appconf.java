package ocn.site.sf.mvc.webdatabinder.validator.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ocn.site.sf.mvc.webdatabinder.validator.i18n")
public class Appconf extends WebMvcConfigurerAdapter {

	private final static String PREFIX = "/WEB-INF/";
	private final static String SUFFIX = ".jsp";
	private final static String BEAN_MESSAGESOURCE = "messageSource";
	private final static String i18n_FILEPATH = "i18n.message";

	@Bean("paramMap")
	public LinkedMultiValueMap<?, ?> getLinkedMultiValueMap() {
		return new LinkedMultiValueMap<>();
	}

	@Bean(BEAN_MESSAGESOURCE)
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(i18n_FILEPATH);
		return messageSource;
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
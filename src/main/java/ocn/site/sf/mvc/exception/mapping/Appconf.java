package ocn.site.sf.mvc.exception.mapping;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ocn.site.sf.mvc.exception.mapping")
public class Appconf extends WebMvcConfigurerAdapter {

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// must read doc of SimpleMappingExceptionResolver , include methods
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties pops = new Properties();
		pops.put(Exception.class.getName().toString(), "error");
		exceptionResolver.setExceptionMappings(pops);
		exceptionResolvers.add(exceptionResolver);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}
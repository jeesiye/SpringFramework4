package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@WebAppConfiguration
@Configuration
@ComponentScan("ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b")
public class Appconf extends DelegatingWebMvcConfiguration {

	// reference for : RequestMappingHandlerAdapter
	@Bean
	@Override
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
		handlerAdapter.setWebBindingInitializer(new PropertyEditorRegister());
		return handlerAdapter;
	}

	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}

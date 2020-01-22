package ocn.site.sf.mvc.httpmessage.jackson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("ocn.site.sf.mvc.httpmessage.jackson")
public class Appconf extends WebMvcConfigurerAdapter {

//	// @EnableWebMvc doc reference
//	If WebMvcConfigurer does not expose some advanced setting that needs to be configured,
//	consider removing the @EnableWebMvc annotation and extending directly from WebMvcConfigurationSupport or DelegatingWebMvcConfiguration, e.g.:
//
//	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.jackson2Present
//		private static final boolean jackson2Present =
//				ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper",
//						WebMvcConfigurationSupport.class.getClassLoader()) &&
//				ClassUtils.isPresent("com.fasterxml.jackson.core.JsonGenerator",
//						WebMvcConfigurationSupport.class.getClassLoader());
//
//	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.addDefaultHttpMessageConverters(List<HttpMessageConverter<?>>)
//			if (jackson2Present) {
//				messageConverters.add(new MappingJackson2HttpMessageConverter(
//						Jackson2ObjectMapperBuilder.json().applicationContext(this.applicationContext).build()));
//			}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}

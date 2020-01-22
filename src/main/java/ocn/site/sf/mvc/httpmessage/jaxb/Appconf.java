package ocn.site.sf.mvc.httpmessage.jaxb;

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
@ComponentScan("ocn.site.sf.mvc.httpmessage.jaxb")
public class Appconf extends WebMvcConfigurerAdapter {

//	// @EnableWebMvc doc reference
//	If WebMvcConfigurer does not expose some advanced setting that needs to be configured,
//	consider removing the @EnableWebMvc annotation and extending directly from WebMvcConfigurationSupport or DelegatingWebMvcConfiguration, e.g.:
//
//	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.jaxb2Present
//		private static final boolean jaxb2Present =
//				ClassUtils.isPresent("javax.xml.bind.Binder",
//						WebMvcConfigurationSupport.class.getClassLoader());
//
//	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.jackson2XmlPresent
//		private static final boolean jackson2XmlPresent =
//				ClassUtils.isPresent("com.fasterxml.jackson.dataformat.xml.XmlMapper",
//						WebMvcConfigurationSupport.class.getClassLoader());
//
//	// org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.addDefaultHttpMessageConverters(List<HttpMessageConverter<?>>)
//			if (jackson2XmlPresent) {
//				messageConverters.add(new MappingJackson2XmlHttpMessageConverter(
//						Jackson2ObjectMapperBuilder.xml().applicationContext(this.applicationContext).build()));
//			}
//			else if (jaxb2Present) {
//				messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
//			}

//	配置单元测试的时候，对dtd的支持，但是配置不成功，具体原因有时间再解决。
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter = new Jaxb2RootElementHttpMessageConverter();
//		jaxb2RootElementHttpMessageConverter.setSupportDtd(false);
////		jaxb2RootElementHttpMessageConverter.setProcessExternalEntities(true);
//		converters.add(jaxb2RootElementHttpMessageConverter);
//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}

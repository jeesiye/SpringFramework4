package ocn.site.sf.mvc.httpmessage.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@EnableWebMvc
@Configuration
@ComponentScan("ocn.site.sf.mvc.httpmessage.fastjson")
public class Appconf extends WebMvcConfigurerAdapter {

//	messageConverters	(id=279)
//	elementData	Object[10]  (id=304)
//		[0]	ByteArrayHttpMessageConverter  (id=307)
//		[1]	StringHttpMessageConverter  (id=312)
//		[2]	ResourceHttpMessageConverter  (id=314)
//		[3]	SourceHttpMessageConverter<T>  (id=316)
//		[4]	AllEncompassingFormHttpMessageConverter  (id=318)
//		[5]	Jaxb2RootElementHttpMessageConverter  (id=321)
//		[6]	FastJsonHttpMessageConverter  (id=325)
//		[7]	null
//		[8]	null
//		[9]	null
//	modCount	7
//	size	7
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// version <= 1.2.28
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		List<MediaType> list = new ArrayList<>();
		list.add(MediaType.TEXT_HTML);
		list.add(MediaType.APPLICATION_JSON);
		list.add(MediaType.APPLICATION_XML);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(list);
		converters.add(fastJsonHttpMessageConverter);
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

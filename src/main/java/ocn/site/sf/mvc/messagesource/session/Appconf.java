package ocn.site.sf.mvc.messagesource.session;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("ocn.site.sf.mvc.messagesource.session")
public class Appconf extends WebMvcConfigurerAdapter {

	// 应当特别关注此处的配置。有时配置错误，会出现以下的错误信息提示
	// No message found under code xxx for locale xxx
	// 出现以上的配置错误，往往有以下几点原因。
	// 1）找不到本地化属性文件，该文件是要放置在src目录下的！
	// 如果内嵌了多层目录，使用英文符号.而不是英文符号/，比如 ocn.site.springmvc.i18n.message
	// 2）本地属性文件名称匹配错误，一般命名为 message_zh_CN.properties
	// 3）相关处理的组件未被正确的注册。
	// 注意！不论是java-config还是xml-config的配置，都是要手动的配置bean的名称的。
	// 这里在测试的时候，使用默认的驼峰命名机制是失败的，具体原因待定。
	// MessageSource相关的组件，一定要命名为 messageSource
	// LocaleResolver相关的组件，一定要命名为 localeResolver
	@Bean(value = "messageSource") // must defined beanname
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n.message");
		return messageSource;
	}

	@Bean(value = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
	public LocaleResolver getLocaleResolver() {
		return new SessionLocaleResolver();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
//		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}

package ocn.site.sf.mvc.messagesource.httpheader;

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
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

////reference : org.springframework.web.servlet.i18n.LocaleChangeInterceptor
//
////org.springframework.web.servlet.i18n.LocaleChangeInterceptor.DEFAULT_PARAM_NAME
//	public static final String DEFAULT_PARAM_NAME = "locale";
//
////org.springframework.web.servlet.i18n.LocaleChangeInterceptor.paramName
//	private String paramName = DEFAULT_PARAM_NAME;
//
////org.springframework.web.servlet.i18n.LocaleChangeInterceptor.setParamName(String)
//	public void setParamName(String paramName) {
//		this.paramName = paramName;
//	}
//
////org.springframework.web.servlet.i18n.LocaleChangeInterceptor.preHandle(HttpServletRequest, HttpServletResponse, Object)
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws ServletException {
//
//		String newLocale = request.getParameter(getParamName());
//		if (newLocale != null) {
//			if (checkHttpMethod(request.getMethod())) {
//				LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//				if (localeResolver == null) {
//					throw new IllegalStateException(
//							"No LocaleResolver found: not in a DispatcherServlet request?");
//				}
//				try {
//					localeResolver.setLocale(request, response, parseLocaleValue(newLocale));
//				}
//				catch (IllegalArgumentException ex) {
//					if (isIgnoreInvalidLocale()) {
//						logger.debug("Ignoring invalid locale value [" + newLocale + "]: " + ex.getMessage());
//					}
//					else {
//						throw ex;
//					}
//				}
//			}
//		}
//		// Proceed in any case.
//		return true;
//	}

@EnableWebMvc
@Configuration
@ComponentScan("ocn.site.sf.mvc.messagesource.httpheader")
public class Appconf extends WebMvcConfigurerAdapter {

	private final static String PREFIX = "/WEB-INF/";
	private final static String SUFFIX = ".jsp";

	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n.message");
		return messageSource;
	}

	@Bean(value = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
	public LocaleResolver getLocaleResolver() {
		// 测试两个组件均生效
//		return new CookieLocaleResolver();
//		return new SessionLocaleResolver();
		return new AcceptHeaderLocaleResolver();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 该拦截器可自定义，查看源码setter方法，paramName属性。
		registry.addInterceptor(new LocaleChangeInterceptor());
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

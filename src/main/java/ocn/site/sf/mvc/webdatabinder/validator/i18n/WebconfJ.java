//package ocn.site.sf.mvc.webdatabinder.validator.i18n;
//
//import javax.servlet.Filter;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebconfJ extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	private final static String ENCODING = "utf-8";
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[] { Appconf.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] { new CharacterEncodingFilter(ENCODING, true), new HiddenHttpMethodFilter() };
//	}
//
//}
//package ocn.site.sf.mvc.tag.form;
//
//import javax.servlet.Filter;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebconfJ extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { Appconf.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] { new CharacterEncodingFilter("utf-8", true), new HiddenHttpMethodFilter() };
//	}
//
//}

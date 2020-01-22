//package ocn.site.sf.mvc.webdatabinder.format.formatter;
//
//import javax.servlet.Filter;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
//public class WebconfX extends AbstractDispatcherServletInitializer {
//	private final static String confpath = "classpath:ocn/site/sf/mvc/webdatabinder/format/formatter/appconf.xml";
//
//	@Override
//	protected WebApplicationContext createServletApplicationContext() {
//		// TODO Auto-generated method stub
//		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//		ctx.setConfigLocation(confpath);
//		return ctx;
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] { "/" };
//	}
//
//	@Override
//	protected WebApplicationContext createRootApplicationContext() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		// TODO Auto-generated method stub
//		return new Filter[] { new CharacterEncodingFilter("utf-8", true), new HiddenHttpMethodFilter() };
//	}
//
//}

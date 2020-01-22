//package ocn.site.sf.mvc.webfile.upload;
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
//
//	private final static String confpath = "classpath:/ocn/site/sf/mvc/webfile/upload/appconf.xml";
//
//	@Override
//	protected WebApplicationContext createServletApplicationContext() {
//		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//		ctx.setConfigLocation(confpath);
//		return ctx;
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//	@Override
//	protected WebApplicationContext createRootApplicationContext() {
//		return null;
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] { new CharacterEncodingFilter("utf-8", true), new HiddenHttpMethodFilter() };
//	}
//
//}
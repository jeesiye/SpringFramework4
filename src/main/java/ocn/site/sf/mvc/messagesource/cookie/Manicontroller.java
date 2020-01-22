package ocn.site.sf.mvc.messagesource.cookie;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();
	private @Autowired LocaleResolver localeResolver;// CookieLocaleResolver instance

	@GetMapping("/test/{var}")
	public String handler(HttpServletRequest request, HttpServletResponse response, @PathVariable("var") String path,
			@RequestParam String locale) {
		if ("china".equals(locale)) {
			localeResolver.setLocale(request, response, new Locale("zh", "CN"));
		} else if ("english".equals(locale)) {
			localeResolver.setLocale(request, response, new Locale("en", "US"));
		} else {
			localeResolver.setLocale(request, response, LocaleContextHolder.getLocale());
		}
		RequestContext requestContext = new RequestContext(request);
		logger.info(requestContext.getMessage("username"));
		logger.info(requestContext.getMessage("passwd"));
		return path;
	}

}
package ocn.site.sf.mvc.messagesource.session;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@GetMapping("/test/{var}")
	public String handler(HttpServletRequest request, @PathVariable("var") String path, @RequestParam String locale) {
		HttpSession session = request.getSession();
		if ("china".equals(locale)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
		} else if ("english".equals(locale)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
		} else {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
		}
		RequestContext requestContext = new RequestContext(request);
		logger.info(requestContext.getMessage("username"));
		logger.info(requestContext.getMessage("passwd"));
		return path;
	}

}
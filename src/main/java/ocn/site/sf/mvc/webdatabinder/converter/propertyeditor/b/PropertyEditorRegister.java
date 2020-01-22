package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

//should used annotation @InitBinder
public class PropertyEditorRegister implements WebBindingInitializer {

	// deprecated
//	private @Autowired String2Date string2Date;

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new String2Date());
	}

}

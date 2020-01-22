package ocn.site.sf.mvc.webdatabinder.format.formatterregistrar;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class FormatterRegistrarImpl implements FormatterRegistrar {

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormat());
	}

}
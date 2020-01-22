package ocn.site.sf.mvc.httpmessage.jackson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@PostMapping(path = "/test", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User handler(@RequestBody User user) throws CloneNotSupportedException {
		logger.info(user);
		User value = user.clone();
		value.setName("rose");
		return value;
	}

}
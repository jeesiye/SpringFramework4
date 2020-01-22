package ocn.site.sf.mvc.httpmessage.jaxb;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	@PostMapping(path = "/test", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public User handler(@RequestBody User user) throws CloneNotSupportedException, JAXBException {
		logger.info(user);
//		InputStream is = this.getClass().getResourceAsStream("/source/data.xml");
		String path = this.getClass().getPackage().getName().replaceAll("\\.", "/").concat(File.separator + "data.xml");
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
		if (is == null)
			return null;
		// 使用jaxb将xml转换为pojo，内置提供了接口也可逆向转换。
		User value = (User) JAXBContext.newInstance(User.class).createUnmarshaller().unmarshal(is);
		return value;
	}

}
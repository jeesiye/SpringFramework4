package ocn.site.sf.mvc.webfile.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

////follow reference
//
////org.springframework.web.servlet.DispatcherServlet
//
////org.springframework.web.servlet.DispatcherServlet.multipartResolver
//	private MultipartResolver multipartResolver;
//
////org.springframework.web.servlet.DispatcherServlet.initMultipartResolver(ApplicationContext)
//	private void initMultipartResolver(ApplicationContext context) {
//		try {
//			this.multipartResolver = context.getBean(MULTIPART_RESOLVER_BEAN_NAME, MultipartResolver.class);
//			if (logger.isDebugEnabled()) {
//				logger.debug("Using MultipartResolver [" + this.multipartResolver + "]");
//			}
//		}
//		catch (NoSuchBeanDefinitionException ex) {
//			// Default is no multipart resolver.
//			this.multipartResolver = null;
//			if (logger.isDebugEnabled()) {
//				logger.debug("Unable to locate MultipartResolver with name '" + MULTIPART_RESOLVER_BEAN_NAME +
//						"': no multipart request handling provided");
//			}
//		}
//	}
//
////org.springframework.web.servlet.DispatcherServlet ==> static init block
//	static {
//		// Load default strategy implementations from properties file.
//		// This is currently strictly internal and not meant to be customized
//		// by application developers.
//		try {
//			ClassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH, DispatcherServlet.class);
//			defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
//		}
//		catch (IOException ex) {
//			throw new IllegalStateException("Could not load '" + DEFAULT_STRATEGIES_PATH + "': " + ex.getMessage());
//		}
//	}
////look file
/////org/springframework/web/servlet/DispatcherServlet.properties

//使用的是spring内置的上传组件功能，但是依赖apache的上传开源包
//也可使用支持servlet3.0内置的上传功能。
@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();

	// MultipartFile接口的说明
	// 使用此接口来接收浏览器上传到服务端的文件字节流的
//		getName() : 获取form表单中,文件控件的input元素的name的值
//		getOriginalFilename() : 获取文件的原始名称,即文件名
//		getContentType() : 获取文件的MIME类型
//		getSize() : 获取文件的大小,单位是byte
//		getBytes() : 获取上传得到的文件流的字节数组,类型是byte[]数组
//		getInputStream() : 获取上传文件得到的输入流,类型是 inputstream
//		transferTo() : 将获取的数据流写入到指定的文件流对象中
//		isEmpty() : 返回的是布尔类型,判断获取的文件流是否是空引用
	// 以上方法使用到最多的是transferTo和isEmpty方法
	// 以下是上传文件功能的处理,实际的使用中,应当进行逻辑判断甄别是否为空
	@PostMapping("/test")
	public void handler(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		try {
			String realPath = request.getServletContext().getRealPath("/WEB-INF");
			File file = new File(realPath + File.separator + multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			logger.info("upload success");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			logger.info("handler failed");
		}
	}
}
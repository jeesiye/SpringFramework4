package ocn.site.sf.mvc.webfile.download;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Manicontroller {

	private final Logger logger = LogManager.getLogger();
	// 相关http的基础信息 查询关键字 http mdn
	// Content-Disposition 消息头指定回复的信息是以内联(inline)的形式还是以附件(attchement)的形式显示
	private final static String ATTACHMENT_CONTENTDISPOSITION_KEY = "attachment";
	private String filepath = "/WEB-INF/file.txt";// 服务器提供下载文件的目录
	private String filename = "file.txt";// 需要包含文件的类型比如 file.txt

	@GetMapping("/test")
	public ResponseEntity<byte[]> handler(HttpServletRequest request) throws IOException {
		String realPath = request.getServletContext().getRealPath(filepath);
		File file = new File(realPath);
		byte[] datas = FileUtils.readFileToByteArray(file);// commons-io

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData(ATTACHMENT_CONTENTDISPOSITION_KEY, filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		logger.info("handler success");
		return new ResponseEntity<byte[]>(datas, headers, HttpStatus.CREATED);
	}
}
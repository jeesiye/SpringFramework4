package ocn.site.sf.mvc.exception.responsestatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "annotation used on exception class")
public class StatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Logger logger = LogManager.getLogger();

	public StatusException() {
		super();
		logger.info("used on exception class success");
		// TODO Auto-generated constructor stub
	}

	public StatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StatusException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StatusException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StatusException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
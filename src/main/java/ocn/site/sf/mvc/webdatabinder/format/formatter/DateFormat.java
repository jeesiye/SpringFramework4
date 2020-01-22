package ocn.site.sf.mvc.webdatabinder.format.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormat implements Formatter<Date> {

	@Override
	public String print(Date object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date value = format.parse(text);
		return value;
	}

}

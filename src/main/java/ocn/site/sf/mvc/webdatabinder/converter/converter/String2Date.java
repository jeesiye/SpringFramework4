package ocn.site.sf.mvc.webdatabinder.converter.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//reference package ==> org.springframework.core.convert.converter
//可使用的接口有以下
//org.springframework.core.convert.converter.Converter<S, T>
//org.springframework.core.convert.converter.ConverterFactory<S, R>
//org.springframework.core.convert.converter.GenericConverter
public class String2Date implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date value = format.parse(source);
			return value;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
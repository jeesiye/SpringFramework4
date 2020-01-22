package ocn.site.sf.mvc.webdatabinder.converter.propertyeditor.b;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//should be reference interface is : java.beans.PropertyEditor
//always used : java.beans.PropertyEditorSupport
//有所局限性，仅支持将字符串转换为java对象。这和webmvc中的格式化功能类似，一般很少使用。
public class String2Date extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date value = format.parse(text);
			setValue(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
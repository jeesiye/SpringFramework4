package ocn.site.sf.ioc.bean.replacedmethod;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacerImpl implements MethodReplacer {

	private final static Logger log = LogManager.getLogger();

//  参数列表说明:
//  obj : 表示的需要替换方法的目标类实例;
//  method : 需要替换的方法签名;
//  args : 需要替换的方法的参数列表;
//  return : 自定义该方法的返回值;注意类型要和目标类方法返回类型一致.
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		log.info("replaced method is running");
		return null;
	}

}

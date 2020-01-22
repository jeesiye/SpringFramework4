package ocn.site.sf.mvc.webdatabinder.validator.jsr303.extension;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//无需使用 @Component 标记注册  此验证约束会生效
public class ConstraintValidatorImpl implements ConstraintValidator<FieldSize, String> {

	private int size = 0;

	@Override
	public void initialize(FieldSize constraintAnnotation) {
		this.size = constraintAnnotation.size();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.length() < this.size) {
			return true;
		}
		return false;
	}

}

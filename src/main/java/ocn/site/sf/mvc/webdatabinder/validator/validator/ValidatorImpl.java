package ocn.site.sf.mvc.webdatabinder.validator.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidatorImpl implements Validator {

	// 应当参考的类对象有如下
	// org.springframework.validation.Validator
	// org.springframework.validation.Errors
	// org.springframework.validation.ValidationUtils
	// org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!"hack".equals(user.getName())) {
			errors.rejectValue("name", null, "username must hack");
		}
	}

}

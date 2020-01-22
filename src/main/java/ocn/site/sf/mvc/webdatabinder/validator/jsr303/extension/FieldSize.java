package ocn.site.sf.mvc.webdatabinder.validator.jsr303.extension;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

//通常对于一个bean的约束由两部分组成
//使用 @Constraint 约束注解及其相关的配置信息
//实现 ConstraintValidator 的接口 并与之关联

//默认情况下 LocalValidatorFactoryBean 会配置 SpringConstraintValidatorFactory
//然后spring容器会使用它 来创建 ConstraintValidator 的实例

//因为需要强制的使用第三方资源包 是否推荐使用 看具体需求
//但是其依赖的同样是hibernate的JSR303的实现 故在大多数的场景下 此功能是推荐使用的
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConstraintValidatorImpl.class)
public @interface FieldSize {

	String message() default "max length errors";

	Class<?>[] groups() default {};

	Class<?>[] payload() default {};

	int size() default 4;

}

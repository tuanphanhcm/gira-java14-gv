package cybersoft.javabackend.girajava14gv.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.girajava14gv.role.validation.validator.UniqueRoleNameValidator;

@Constraint(validatedBy = UniqueRoleNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueRoleName {
	String message() default "Role name is used.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

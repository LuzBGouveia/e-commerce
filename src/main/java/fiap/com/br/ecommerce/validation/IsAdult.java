package fiap.com.br.ecommerce.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AdultValidator.class)
public @interface IsAdult {
    String message() default "O usuário deve ser maior de idade.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

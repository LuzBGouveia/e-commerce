package fiap.com.br.ecommerce.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = UserRoleValidator.class)
public @interface UserRoleValidation {
    String message() default "Para o papel de CLIENTE, o campo CPF deve ser preenchido. Para o papel de SUPPLIER o CNPJ deve ser preenchido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

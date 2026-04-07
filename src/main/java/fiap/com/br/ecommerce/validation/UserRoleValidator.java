package fiap.com.br.ecommerce.validation;

import fiap.com.br.ecommerce.dto.UserRequest;
import fiap.com.br.ecommerce.entity.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<UserRoleValidation, UserRequest> {
    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext context) {
        var valid = true;

        if(userRequest.role() == Role.CLIENT && !fieldIsValid(userRequest.cpf())) {
            valid = false;
            addViolation(context, "cpf", "cpf é obrigatório para clientes.");
        }

        if (userRequest.role() == Role.SUPPLIER && !fieldIsValid(userRequest.cnpj())) {
            valid = false;
            addViolation(context, "cnpj", "CNPJ é obrigatório para fornecedores.");
        }
        return valid;
    }

    private boolean fieldIsValid(String value) {
        return value != null && !value.isBlank();
    }

    private void addViolation(ConstraintValidatorContext context, String message, String field) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
    }
}

package fiap.com.br.ecommerce.dto;


import fiap.com.br.ecommerce.entity.Role;
import fiap.com.br.ecommerce.entity.User;
import fiap.com.br.ecommerce.validation.IsAdult;
import fiap.com.br.ecommerce.validation.UserRoleValidation;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDate;
@UserRoleValidation
public record UserRequest(
        @NotBlank
        String name,

        //@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$")
        @CPF
        String cpf,

        @CNPJ
        String cnpj,

        @Email
        String email,

        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") //⚠️ i18n
        String password,

        @IsAdult
        LocalDate birthDate,

        @Min(1) @Max(5)
        Integer rating,

        @NotNull
        Role role
) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .cpf(cpf)
                .cnpj(cnpj)
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .rating(rating)
                .role(role)
                .build();
    }
}

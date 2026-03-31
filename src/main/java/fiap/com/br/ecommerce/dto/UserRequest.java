package fiap.com.br.ecommerce.dto;


import fiap.com.br.ecommerce.entity.User;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDate;

@NotNull
public record UserRequest(
        @NotBlank
        String name,

        //@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$")
        @CPF
        String cpf,

        @Email
        String email,

        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") //⚠️ i18n
        String password,

        @Past
        LocalDate birthDate,

        @Min(1) @Max(5)
        Integer rating
) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .cpf(cpf)
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .rating(rating)
                .build();
    }
}

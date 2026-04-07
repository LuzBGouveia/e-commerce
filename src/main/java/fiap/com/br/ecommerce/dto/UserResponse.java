package fiap.com.br.ecommerce.dto;

import fiap.com.br.ecommerce.entity.Role;
import fiap.com.br.ecommerce.entity.User;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String name,
        String cpf,
        String cnpj,
        String email,
        LocalDate birthDate,
        Integer rating,
        Role role
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getCnpj(),
                user.getEmail(),
                user.getBirthDate(),
                user.getRating(),
                user.getRole()
        );
    }
}

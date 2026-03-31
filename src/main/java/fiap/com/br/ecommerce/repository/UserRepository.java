package fiap.com.br.ecommerce.repository;

import fiap.com.br.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

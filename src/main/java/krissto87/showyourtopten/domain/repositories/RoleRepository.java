package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);
}

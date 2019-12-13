package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "insert into users(email, password, username, active) values\n" +
            "('admin@admin.pl', '{noop}admin', 'admin', true);", nativeQuery = true)
    void createAdmin();@Transactional
    @Modifying
    @Query(value = "insert into users_roles(user_id, roles_id) VALUES\n" +
            "(SELECT id FROM users WHERE username = 'admin',2);", nativeQuery = true)
    void makeAdminAdmin();

}

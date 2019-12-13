package krissto87.showyourtopten.setup;

import krissto87.showyourtopten.domain.entities.Role;
import krissto87.showyourtopten.domain.repositories.RoleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @Profile("heroku")
public class SomeStarterClass implements ApplicationRunner {

    private final RoleRepository roleRepository;

    public SomeStarterClass(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Role userRole = new Role();
        userRole.setId(1L);
        userRole.setName("ROLE_USER");
        Role userRol2 = new Role();
        roleRepository.save(userRole);
        userRol2.setId(2L);
        userRol2.setName("ROLE_ADMIN");
        roleRepository.save(userRol2);
    }
}

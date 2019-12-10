package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.Role;
import krissto87.showyourtopten.domain.entities.User;
import krissto87.showyourtopten.domain.repositories.RoleRepository;
import krissto87.showyourtopten.domain.repositories.UserRepository;
import krissto87.showyourtopten.dtos.RegistrationDataDTO;
import krissto87.showyourtopten.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDataDTO registrationData) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationData, User.class);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);
    }
}

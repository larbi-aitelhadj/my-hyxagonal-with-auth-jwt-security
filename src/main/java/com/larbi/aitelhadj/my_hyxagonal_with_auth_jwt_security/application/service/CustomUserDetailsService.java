package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.application.service;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.User;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

/**
 * @larbi.aitelhadj
 */

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null ) {
            throw new UsernameNotFoundException("Utilisateur inexistant - username : " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
    }
}

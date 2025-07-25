package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

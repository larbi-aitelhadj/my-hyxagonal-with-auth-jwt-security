package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @larbi.aitelhadj
 *
 *
 */
@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
}

package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.port;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import java.util.List;

/**
 * @larbi.aitelhadj
 *
 *
 */
public interface ProduitRepositoryPort {

    Produit create(Produit produit);
    Produit findById(Long id);
    void deleteById(Long id);
    List<Produit> findAll();

}

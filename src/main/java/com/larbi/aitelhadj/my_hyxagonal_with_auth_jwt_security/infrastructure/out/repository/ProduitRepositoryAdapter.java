package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.port.ProduitRepositoryPort;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.ProduitEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProduitRepositoryAdapter implements ProduitRepositoryPort {

    private ProduitRepository produitRepository;

    ProduitRepositoryAdapter(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit create(Produit produit) {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity = produitEntity.toEntity(produit);
        produitEntity = produitRepository.save(produitEntity);
        produit.setId(produitEntity.getId());
        return produit;
    }

    @Override
    public Produit findById(Long id) {
        ProduitEntity produitEntity = produitRepository.findById(id).orElse(null);
        return produitEntity != null ? produitEntity.toModel() : null;
    }

    @Override
    public void deleteById(Long id) {
        produitRepository.findById(id).ifPresent(produitRepository::delete);
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = new ArrayList<>();
        produitRepository.findAll().forEach(
                produitEntity -> produitList.add(produitEntity.toModel()));
        return produitList;
    }
}

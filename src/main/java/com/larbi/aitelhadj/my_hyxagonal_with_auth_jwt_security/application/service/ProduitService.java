package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.application.service;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository.ProduitRepositoryAdapter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitService {

    private ProduitRepositoryAdapter produitRepositoryAdapter;

    ProduitService(ProduitRepositoryAdapter produitRepositoryAdapter) {
        this.produitRepositoryAdapter = produitRepositoryAdapter;
    }

    public Produit createProduit(Produit produit) {
        return produitRepositoryAdapter.create(produit);
    }

    public void deleteProduitById(Long id) {
        produitRepositoryAdapter.deleteById(id);
    }

    public Produit findProduitById(Long id) {
        return produitRepositoryAdapter.findById(id);
    }

    public List<Produit> getAllProduits() {
        return produitRepositoryAdapter.findAll();
    }

}

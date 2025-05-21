package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.in.controller;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.application.service.ProduitService;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @larbi.aitelhadj
 *
 *
 */
@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/create")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.createProduit(produit));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteProduitById(@RequestParam Long id) {
        produitService.deleteProduitById(id);
        return ResponseEntity.ok().body("suppression produit avec succès !!");
    }

    @GetMapping("/findById")
    public ResponseEntity<Produit> findProduitById(@RequestParam Long id) {
        return ResponseEntity.ok(produitService.findProduitById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }
}

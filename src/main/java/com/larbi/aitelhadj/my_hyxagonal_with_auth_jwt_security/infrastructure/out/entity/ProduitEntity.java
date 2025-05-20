package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;

    public Produit toModel() {
        Produit produit = new Produit();
        produit.setId(this.id);
        produit.setName(this.name);
        produit.setPrice(this.price);
        produit.setDescription(this.description);
        return produit;
    }

    public ProduitEntity toEntity(Produit produit) {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setId(produit.getId());
        produitEntity.setName(produit.getName());
        produitEntity.setPrice(produit.getPrice());
        produitEntity.setDescription(produit.getDescription());
        return produitEntity;
    }

}

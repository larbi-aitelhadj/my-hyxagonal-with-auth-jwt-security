package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model;

/**
 * @larbi.aitelhadj
 *
 *
 */
public class Produit {

    private Long id;
    private String name;
    private Double price;
    private String description;

    public Produit() { }

    public Produit(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.in.controller;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.application.service.ProduitService;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @larbi.aitelhadj
 *
 *
 */
@WebMvcTest(ProduitController.class)
class ProduitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduitService produitService;

    //@Test
    void createProduit() throws Exception {
        String json = """
                {
                "id": 1,
                "name": "PC",
                "price": 9874.36,
                "description": "Description 1"
                }
                """;
        Produit produit = new Produit(1L, "PC", 9874.36, "Description 1");
        when(produitService.createProduit(any(Produit.class))).thenReturn(produit);
        mockMvc.perform(post("/produits/create")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("PC"))
                .andExpect(jsonPath("$.price").value(9874.36))
                .andExpect(jsonPath("$.description").value("Description 1"));
    }

    //@Test
    void deleteProduitById() throws Exception {
        mockMvc.perform(delete("/produits/deleteById").param("id", "1"))
                .andExpect(status().isOk());
    }

    //@Test
    void findProduitById() throws Exception {
        Produit produit = new Produit(1L, "PC", 9874.25, "Description 1");
        when(produitService.findProduitById(1L)).thenReturn(produit);
        mockMvc.perform(get("/produits/findById").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("PC"))
                .andExpect(jsonPath("$.price").value(9874.25))
                .andExpect(jsonPath("$.description").value("Description 1"));
    }

    //@Test
    void getAllProduits() throws Exception {
        Produit p1 = new Produit(1L, "PC", 9874.25, "Description 1");
        Produit p2 = new Produit(2L, "Télephone", 6548.36, "Description 2");
        when(produitService.getAllProduits()).thenReturn(List.of(p1, p2));
        mockMvc.perform(get("/produits/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath(("$[0].name")).value("PC"))
                .andExpect(jsonPath("$[0].price").value(9874.25))
                .andExpect(jsonPath("$[0].description").value("Description 1"));
    }
}
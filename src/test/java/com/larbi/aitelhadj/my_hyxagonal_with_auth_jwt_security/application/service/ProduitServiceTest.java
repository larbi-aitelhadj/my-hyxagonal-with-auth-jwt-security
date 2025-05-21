package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.application.service;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.domain.model.Produit;
import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository.ProduitRepositoryAdapter;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/**
 * @larbi.aitelhadj
 *
 *
 */
//@SpringBootTest
public class ProduitServiceTest {

    @Mock
    private ProduitRepositoryAdapter produitRepositoryAdapter;

    @InjectMocks
    private ProduitService produitService;

    //@Test
    void createProduit() {
        Produit produit = new Produit(1L, "PC", 8796.23, "Description PC");
        when(produitRepositoryAdapter.create(produit)).thenReturn(produit);
        Produit produitSaved = produitService.createProduit(produit);
        assertNotNull(produitSaved);
        assertEquals(1L, produit.getId());
        assertEquals("PC", produit.getName());
        assertEquals(8796.23, produit.getPrice());
        assertEquals("Description PC", produitSaved.getDescription());
    }

    //@Test
    void deleteProduitById() {
        produitService.deleteProduitById(1L);
        verify(produitRepositoryAdapter).deleteById(1L);
    }

    //@Test
    void findProduitById() {
        Produit produit = new Produit(1L, "PC", 8796.23, "Description PC");
        when(produitRepositoryAdapter.findById(1L)).thenReturn(produit);
        Produit produitFined = produitService.findProduitById(1L);
        assertNotNull(produitFined);
        assertEquals(1L, produitFined.getId());
        assertEquals("PC", produitFined.getName());
        assertEquals(8796.23, produitFined.getPrice());
        assertEquals("Description PC", produitFined.getDescription());
    }

    //@Test
    void getAllProduits() {
        Produit p1 = new Produit(1L, "PC", 8796.23, "Description PC");
        Produit p2 = new Produit(2L, "Télephone", 6523.14, "Description Télephone");
        when(produitRepositoryAdapter.findAll()).thenReturn(List.of(p1, p2));
        List<Produit> produitList = produitService.getAllProduits();
        assertThat(produitList).size().isEqualTo(2);
        assertEquals(1L, produitList.get(0).getId());
        assertEquals("PC", produitList.get(0).getName());
        assertEquals(8796.23, produitList.get(0).getPrice());
        assertEquals("Description PC", produitList.get(0).getDescription());

    }
}
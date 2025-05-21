package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.ProduitEntity;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

/**
 * @larbi.aitelhadj
 *
 *
 */
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/data_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class ProduitRepositoryTest {

    @Autowired
    ProduitRepository produitRepository;

    @Test
    void testFindAll() {
        List<ProduitEntity> produits = produitRepository.findAll();
        assertThat(produits).hasSize(2);

        ProduitEntity first = produits.getFirst();
        assertThat(first.getId()).isEqualTo(1L);
        assertThat(first.getName()).isEqualTo("PC");
        assertThat(first.getPrice()).isEqualTo(26235.36);
        assertThat(first.getDescription()).isEqualTo("Description 1");
    }

    @Test
    void testFindById() {
        ProduitEntity produit = produitRepository.findById(1L).orElse(null);
        assertThat(produit).isNotNull();
        assertThat(produit.getName()).isEqualTo("PC");
    }

    @Test
    void testSave() {
        ProduitEntity produit = new ProduitEntity();
        produit.setName("Clavier");
        produit.setPrice(65.12);
        produit.setDescription("description clavier");

        ProduitEntity saved = produitRepository.save(produit);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0);
        assertThat(saved.getId()).isEqualTo(3L);
        assertThat(saved.getName()).isEqualTo("Clavier");
        assertThat(saved.getPrice()).isEqualTo(65.12);
        assertThat(saved.getDescription()).isEqualTo("description clavier");
    }

    @Test
    void testDeleteById() {
        produitRepository.deleteById(1L);
        assertNull(produitRepository.findById(1L).orElse(null));
    }

}
package com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.repository;

import com.larbi.aitelhadj.my_hyxagonal_with_auth_jwt_security.infrastructure.out.entity.ProduitEntity;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

/**
 * @larbi.aitelhadj
 *
 *
 */
@DataJpaTest
class ProduitRepositoryTest {

    @Autowired
    ProduitRepository produitRepository;

    //@Test
    void testFindAll() {
        List<ProduitEntity> produitEntityList = produitRepository.findAll();
        assertThat(produitEntityList).size().isEqualTo(2);
        assertEquals(1L, produitEntityList.get(0).getId());
        assertEquals("PC", produitEntityList.get(0).getName());
        assertEquals(9875.36, produitEntityList.get(0).getPrice());
        assertEquals("description PC", produitEntityList.get(0).getDescription());
    }

    //@Test
    void testFindById() {
        ProduitEntity produitEntity = produitRepository.findById(1L).orElse(null);
        assertNotNull(produitEntity);
        assertEquals(1L, produitEntity.getId());
        assertEquals("PC", produitEntity.getName());
        assertEquals(9875.36, produitEntity.getPrice());
        assertEquals("description PC", produitEntity.getDescription());
    }

    //@Test
    void testSave() {
        ProduitEntity produitEntity = new ProduitEntity();
        produitEntity.setName("Clavier");
        produitEntity.setPrice(65.12);
        produitEntity.setDescription("description clavier");
        ProduitEntity produitEntitySaved = produitRepository.save(produitEntity);
        assertNotNull(produitEntitySaved);
        assertEquals(3L, produitEntitySaved.getId());
        assertEquals("Clavier", produitEntitySaved.getName());
        assertEquals(65.12, produitEntitySaved.getPrice());
        assertEquals("description clavier", produitEntitySaved.getDescription());
    }

    //@Test
    void testDeleteById() {
        produitRepository.deleteById(1L);
        assertNull(produitRepository.findById(1L).orElse(null));
    }

}
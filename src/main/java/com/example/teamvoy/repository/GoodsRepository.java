package com.example.teamvoy.repository;

import com.example.teamvoy.model.Goods;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    @Query("select g from Goods g where g.product.id = :id and g.isInShoppingCart = false")
    Optional<Goods> findByProductId(Long id);
}

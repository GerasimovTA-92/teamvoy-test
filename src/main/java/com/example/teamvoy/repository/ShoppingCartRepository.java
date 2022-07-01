package com.example.teamvoy.repository;

import com.example.teamvoy.model.ShoppingCart;
import com.example.teamvoy.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("select distinct sc from ShoppingCart sc "
            + "left join fetch sc.goods left join fetch sc.user where sc.user = :user")
    ShoppingCart findByUser(User user);

    List<ShoppingCart> findAllByTimeCreatedIsLessThan(Long timeCreated);
}

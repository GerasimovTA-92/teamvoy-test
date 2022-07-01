package com.example.teamvoy.repository;

import com.example.teamvoy.model.Order;
import com.example.teamvoy.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select distinct o from Order o "
            + "left join fetch o.goods "
            + "left join fetch o.user where o.user = :user")
    List<Order> findAllByUser(User user);
}

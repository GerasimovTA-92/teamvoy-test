package com.example.teamvoy.service;

import com.example.teamvoy.model.Order;
import com.example.teamvoy.model.ShoppingCart;
import com.example.teamvoy.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> findAllByUser(User user);
}

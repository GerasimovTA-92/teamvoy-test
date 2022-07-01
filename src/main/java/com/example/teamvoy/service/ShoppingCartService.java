package com.example.teamvoy.service;

import com.example.teamvoy.model.Goods;
import com.example.teamvoy.model.ShoppingCart;
import com.example.teamvoy.model.User;
import java.util.List;

public interface ShoppingCartService {
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    ShoppingCart findByUser(User user);

    void createShoppingCart(User user);

    void addGoods(Goods goods, User user);

    List<ShoppingCart> findAllByTimeIsLessThan(Long timeCreated);

    void clear(ShoppingCart shoppingCart);
}

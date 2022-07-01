package com.example.teamvoy.service.impl;

import com.example.teamvoy.model.Goods;
import com.example.teamvoy.model.Order;
import com.example.teamvoy.model.ShoppingCart;
import com.example.teamvoy.model.User;
import com.example.teamvoy.repository.OrderRepository;
import com.example.teamvoy.service.GoodsService;
import com.example.teamvoy.service.OrderService;
import com.example.teamvoy.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final GoodsService goodsService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            GoodsService goodsService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.goodsService = goodsService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setGoods(List.copyOf(shoppingCart.getGoods()));
        order.setUser(shoppingCart.getUser());
        order.setOrderTime(LocalDateTime.now());
        order.getGoods().forEach(e -> {
            Goods goods = goodsService.findByProductId(e.getProduct().getId());
            goods.setCount(goods.getCount() - e.getCount());
            goodsService.save(goods);
        });
        orderRepository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }
}

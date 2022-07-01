package com.example.teamvoy.controller;

import com.example.teamvoy.dto.response.OrderResponseDto;
import com.example.teamvoy.model.Order;
import com.example.teamvoy.model.ShoppingCart;
import com.example.teamvoy.model.User;
import com.example.teamvoy.service.OrderService;
import com.example.teamvoy.service.ShoppingCartService;
import com.example.teamvoy.service.UserService;
import com.example.teamvoy.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final ResponseDtoMapper<OrderResponseDto, Order> responseMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(UserService userService,
                           OrderService orderService,
                           ResponseDtoMapper<OrderResponseDto, Order> responseMapper,
                           ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(Authentication authentication) {
        User user = userService.findUserByEmail(authentication.getName()).orElseThrow(
                () -> new RuntimeException("User with email "
                        + authentication.getName() + " not found"));
        return orderService.findAllByUser(user).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication auth) {
        User user = userService.findUserByEmail(auth.getName()).orElseThrow(
                () -> new RuntimeException("User with email " + auth.getName() + " not found"));
        ShoppingCart shoppingCart = shoppingCartService.findByUser(user);
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}

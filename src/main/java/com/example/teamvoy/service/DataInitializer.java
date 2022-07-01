package com.example.teamvoy.service;

import com.example.teamvoy.model.Goods;
import com.example.teamvoy.model.Product;
import com.example.teamvoy.model.Role;
import com.example.teamvoy.model.User;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final ProductService productService;
    private final GoodsService goodsService;

    public DataInitializer(UserService userService,
                           RoleService roleService,
                           ProductService productService,
                           GoodsService goodsService) {
        this.userService = userService;
        this.roleService = roleService;
        this.productService = productService;
        this.goodsService = goodsService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.save(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.save(userRole);

        User admin = new User();
        admin.setEmail("admin@i.ua");
        admin.setPassword("admin123");
        admin.setRole(adminRole);
        userService.save(admin);

        User user = new User();
        user.setEmail("user@i.ua");
        user.setPassword("123456789");
        user.setRole(userRole);
        userService.save(user);

        Product iphoneX = new Product();
        iphoneX.setName("Iphone X");
        iphoneX.setPrice(BigDecimal.valueOf(1500));
        productService.save(iphoneX);

        Goods goods = new Goods();
        goods.setCount(15L);
        goods.setProduct(iphoneX);
        goodsService.save(goods);

        //shoppingCartService.addGoods(goods, user);
    }
}

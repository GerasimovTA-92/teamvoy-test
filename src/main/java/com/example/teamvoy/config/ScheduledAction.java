package com.example.teamvoy.config;

import com.example.teamvoy.service.ShoppingCartService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledAction {
    private static final Long PERIOD_OF_LIVE = 60 * 10 * 1000L;
    private final ShoppingCartService shoppingCartService;

    public ScheduledAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void checkShoppingCart() {
        shoppingCartService.findAllByTimeIsLessThan(System.currentTimeMillis() - PERIOD_OF_LIVE)
                .forEach(e -> {
                    System.out.println(e.getUser());
                    shoppingCartService.clear(e);
                });

    }
}

package com.example.teamvoy.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private LocalDateTime orderTime;
    private List<GoodsResponseDto> goods;

    public OrderResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<GoodsResponseDto> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsResponseDto> goods) {
        this.goods = goods;
    }
}

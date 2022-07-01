package com.example.teamvoy.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private UserResponseDto userResponseDto;
    private List<GoodsResponseDto> goods;

    public ShoppingCartResponseDto() {
    }

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }

    public List<GoodsResponseDto> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsResponseDto> goods) {
        this.goods = goods;
    }
}

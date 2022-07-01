package com.example.teamvoy.service.mapper;

import com.example.teamvoy.dto.response.GoodsResponseDto;
import com.example.teamvoy.dto.response.OrderResponseDto;
import com.example.teamvoy.model.Goods;
import com.example.teamvoy.model.Order;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private final ResponseDtoMapper<GoodsResponseDto, Goods> goodsMapper;

    public OrderMapper(ResponseDtoMapper<GoodsResponseDto, Goods> goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public OrderResponseDto toDto(Order model) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderTime(model.getOrderTime());
        dto.setId(model.getId());
        dto.setGoods(model.getGoods().stream()
                .map(goodsMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}

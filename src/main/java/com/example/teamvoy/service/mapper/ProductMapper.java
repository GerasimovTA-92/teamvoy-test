package com.example.teamvoy.service.mapper;

import com.example.teamvoy.dto.request.ProductRequestDto;
import com.example.teamvoy.dto.response.ProductResponseDto;
import com.example.teamvoy.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements ResponseDtoMapper<ProductResponseDto, Product>,
            RequestDtoMapper<Product, ProductRequestDto> {
    @Override
    public ProductResponseDto toDto(Product model) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setPrice(model.getPrice());
        return dto;
    }

    @Override
    public Product toModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        return product;
    }
}

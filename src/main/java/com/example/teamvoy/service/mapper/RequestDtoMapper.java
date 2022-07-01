package com.example.teamvoy.service.mapper;

public interface RequestDtoMapper<M, D> {
    M toModel(D dto);
}

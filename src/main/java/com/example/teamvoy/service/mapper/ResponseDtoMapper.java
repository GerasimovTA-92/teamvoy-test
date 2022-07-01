package com.example.teamvoy.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}

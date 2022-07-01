package com.example.teamvoy.service.mapper;

import com.example.teamvoy.dto.response.UserResponseDto;
import com.example.teamvoy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User model) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(model.getId());
        userResponseDto.setEmail(model.getEmail());
        return userResponseDto;
    }
}

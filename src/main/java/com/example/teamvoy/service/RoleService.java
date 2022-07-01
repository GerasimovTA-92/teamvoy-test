package com.example.teamvoy.service;

import com.example.teamvoy.model.Role;

public interface RoleService {
    Role save(Role role);

    Role findByRoleName(Role.RoleName roleName);
}

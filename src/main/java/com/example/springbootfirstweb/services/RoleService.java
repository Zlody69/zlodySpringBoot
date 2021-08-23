package com.example.springbootfirstweb.services;



import com.example.springbootfirstweb.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRoles();

    Role findRoleByName(String name);
}

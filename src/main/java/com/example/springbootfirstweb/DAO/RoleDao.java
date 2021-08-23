package com.example.springbootfirstweb.DAO;



import com.example.springbootfirstweb.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> allRole();

    Role findRoleByName(String name);
}

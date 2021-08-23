package com.example.springbootfirstweb.DAO;


import com.example.springbootfirstweb.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> allRole(){
        return entityManager.createQuery("select role from Role role")
                .getResultList();
    }


    @Override
    public Role findRoleByName(String name){
        Role role = entityManager.createQuery("select role from Role role where role.name=:name",Role.class)
                .setParameter("name", name)
                .getSingleResult();
        return role;
    }

}

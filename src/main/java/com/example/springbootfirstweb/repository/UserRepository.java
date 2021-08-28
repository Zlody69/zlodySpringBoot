package com.example.springbootfirstweb.repository;

import com.example.springbootfirstweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserById(Long id);
    public User findUserByName(String username);
    @Query(value = "select user from User user join fetch user.roles where user.email=:email")
    public User findUserByEmail(@Param("email") String email);

}

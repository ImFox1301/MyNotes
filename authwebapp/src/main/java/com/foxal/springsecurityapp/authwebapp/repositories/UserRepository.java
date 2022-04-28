package com.foxal.springsecurityapp.authwebapp.repositories;

import com.foxal.springsecurityapp.authwebapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByUsername(String username);
    public boolean existsByEmail(String email);
    public boolean existsByUsername(String username);
}

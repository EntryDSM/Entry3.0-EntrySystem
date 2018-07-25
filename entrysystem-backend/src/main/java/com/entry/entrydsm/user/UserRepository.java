package com.entry.entrydsm.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsUserByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}

package com.entry.entrydsm.user;

import com.entry.entrydsm.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsUserByEmail(String email);
}

package com.entry.entrydsm.tempuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TempUserRepository extends JpaRepository<TempUser, String> {
    boolean existsTempUserByEmail(String email);
    Optional<TempUser> findByCode(String code);
}

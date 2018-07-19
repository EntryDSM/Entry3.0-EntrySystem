package com.entry.entrydsm.tempuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempUserRepository extends JpaRepository<TempUser, String> {
    boolean existsTempUserByEmail(String email);
}

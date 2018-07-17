package com.entry.entrydsm.user;

import com.entry.entrydsm.Domain.Info;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String userId;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private Info info;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.createdDate = LocalDateTime.now();
    }
}

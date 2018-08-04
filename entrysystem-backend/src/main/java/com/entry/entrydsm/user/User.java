package com.entry.entrydsm.user;

import com.entry.entrydsm.tempuser.TempUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "user_id", length = 32)
    private String id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private GraduateType graduateType;

    // TODO
//    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL)
//    private Info info;
//
//    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL)
//    private GraduateInfo graduateInfo;

    public User(TempUser tempUser) {
        this.email = tempUser.getEmail();
        this.password = tempUser.getPassword();
        this.graduateType = GraduateType.WILL;
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public User(String email, String password, GraduateType graduateType) {
        this.email = email;
        this.password = password;
        this.graduateType = graduateType;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", graduateType=" + graduateType +
                '}';
    }
}

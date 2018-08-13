package com.entry.entrydsm.info.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Info {
    @Id
    @Column(length = 32)
    private String userId;

    @Column(length = 100, nullable = false)
    private String addressBase;

    @Column(length = 50, nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Admission admission;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AdmissionDetail admissionDetail;

    @Column(length = 6)
    private String examCode;

    @Column(length = 50)
    private String imgPath;


    @Column(length = 15, nullable = false)
    private String myTel;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String parentName;

    @Column(length = 15, nullable = false)
    private String parentTel;

    @Column(nullable = false)
    private Boolean region;

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(length = 1600, nullable = false)
    private String introduce;

    @Column(length = 1600, nullable = false)
    private String studyPlan;

    @Column(length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer receiptCode;

    @Column(nullable = false)
    private LocalDateTime birth;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(userId, info.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

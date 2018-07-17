package com.entry.entrydsm.Domain;

import com.entry.entrydsm.user.User;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
public class Info {
    //TODO : infoId 대신 User.userId를 PK로 써야할까?
    @Id
    @Column(columnDefinition = "INT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer infoId;

    @Column(length = 100)
    private String addressBase;

    @Column(length = 50)
    private String addressDetail;

    @Enumerated(EnumType.STRING)
    private Admission admission = Admission.NORMAL;

    @Column
    private String admissionDetail;

    @Column(nullable = false)
    private boolean region = false;

    @Column(length = 12)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(length = 12)
    private String parentName;

    @Column(length = 20)
    private String parentTel;

    @Column(length = 20)
    private String myTel;

    @Lob
    @Column(length = 1600)
    private String introduce;

    @Lob
    @Column(length = 1600)
    private String studyPlan;

    @Column(length = 50)
    private String imgPath;

    @Column(length = 6, unique = true)
    private String examCode;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        updatedDate = createdDate;
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
        if (admission != Admission.SOCIAL) admissionDetail = null;
    }
}

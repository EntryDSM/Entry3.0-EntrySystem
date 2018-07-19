package com.entry.entrydsm.Domain;

import com.entry.entrydsm.user.User;

import javax.persistence.*;

@Entity
public class GraduateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer graduateId;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer studentGrade;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer studentClass;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer studentNumber;

    @Column(length = 50)
    private String schoolName;

    @Column(length = 32)
    private String schoolCode;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer gradeYear;

    @Enumerated(EnumType.STRING)
    private Status status = Status.WILL;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}

package com.entry.entrydsm.graduate.grade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GraduateGrade {
    @Id
    @Column(length = 32)
    private String userId;

    @Column(nullable = false)
    private Double finalScore;

    @Column(nullable = false, length = 10)
    private Integer volunteerTime;

    @Column(nullable = false, length = 10)
    private Integer periodCut;

    @Column(nullable = false, length = 10)
    private Integer fullCut;

    @Column(nullable = false, length = 10)
    private Integer late;

    @Column(nullable = false, length = 10)
    private Integer earlyLeave;

}

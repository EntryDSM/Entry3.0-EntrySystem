package com.entry.entrydsm.grade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GraduateGrade extends Grade {

    @Column(nullable = false)
    private Double firstGrade;

    @Column(nullable = false)
    private Double secondGrade;

    @Column(nullable = false)
    private Double thirdGrade;

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

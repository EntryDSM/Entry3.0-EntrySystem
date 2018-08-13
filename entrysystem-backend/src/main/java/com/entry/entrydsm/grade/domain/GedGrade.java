package com.entry.entrydsm.grade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GedGrade extends Grade {
    @Column(nullable = false)
    private Double grade;
}

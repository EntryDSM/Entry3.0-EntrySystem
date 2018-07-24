package com.entry.entrydsm.ged.grade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GedGrade {
    @Id
    @Column(length = 32)
    private String userId;

    @Column(nullable = false)
    private Double grade;
}

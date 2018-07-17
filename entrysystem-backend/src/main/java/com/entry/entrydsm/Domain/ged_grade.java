package com.entry.entrydsm.Domain;

import javax.persistence.*;

@Entity
public class ged_grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ged_grade_d;

    @Column
    private double gade;

    @OneToOne
    @JoinColumn(name = "info_id")
    private Info infoId;
}

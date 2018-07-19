package com.entry.entrydsm.Domain;

import javax.persistence.*;

@Entity
public class Graduate_grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer grade_id;

    @Column(columnDefinition = "INT UNSIGNED")
    private int volunteer_time;

    @Column(columnDefinition = "DOUBLE UNSIGNED")
    private double final_score;

    @OneToOne
    @JoinColumn(name = "info_id")
    private Info infoId;
}

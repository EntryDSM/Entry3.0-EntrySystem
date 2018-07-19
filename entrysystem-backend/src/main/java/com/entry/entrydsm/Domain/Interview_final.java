package com.entry.entrydsm.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Interview_final implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer interview_id;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer final_score;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private Info info;
}

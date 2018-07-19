package com.entry.entrydsm.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class grade_info implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer grade_info_id;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean is_pass;

    @Column(length = 1)
    private char score;

    @Column(length = 20)
    private String subject;

    @Column(columnDefinition = "INT UNSIGNED")
    private int grade;

    @Column(columnDefinition = "INT UNSIGNED")
    private int semester;


    @ManyToOne
    @JoinColumn(name = "graduate_grade_id",columnDefinition = "INT UNSIGNED")
    private Graduate_grade grade_id;

}

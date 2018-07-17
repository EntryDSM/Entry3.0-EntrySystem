package com.entry.entrydsm.Domain;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer questionId;

    @Column
    private String form;

    @Column(length = 60)
    private String title;

    @Column(length = 1023)
    private String body;
}

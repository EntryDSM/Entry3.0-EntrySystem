package com.entry.entrydsm.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InterviewData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer interviewDataId;

    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean take_interview;

    @Column
    private String interviewResult;

    @Column
    private String comment;

    @ManyToOne(targetEntity = Interview_final.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "interview_id")
    private Interview_final interview;

    @ManyToOne(targetEntity = Admin.class,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private Info info;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

}

package com.entry.entrydsm.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School {

    @Id
    @Column(length = 10)
    private String code;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String goverment;

    @Column(length = 20)
    private String school_region;

}

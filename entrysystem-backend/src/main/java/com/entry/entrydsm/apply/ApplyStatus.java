package com.entry.entrydsm.apply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplyStatus {
    @Id
    @Column(length = 32)
    private String userId;

    @Column(nullable = false)
    private Boolean finalSubmit;

    @Column(nullable = false)
    private Boolean passStatus;

    @Column(nullable = false)
    private Boolean payment;

    @Column(nullable = false)
    private Boolean receipt;
}

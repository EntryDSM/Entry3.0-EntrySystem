package com.entry.entrydsm.graduate.grade;

import javax.persistence.Column;
import java.io.Serializable;

public class GradeInfoId implements Serializable {
    @Column(length = 32)
    private String userId;
    private Integer semeter;
    private Subject subject;
}

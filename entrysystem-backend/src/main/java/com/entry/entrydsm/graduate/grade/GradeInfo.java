package com.entry.entrydsm.graduate.grade;

import javax.persistence.*;

@Entity
public class GradeInfo {

    @EmbeddedId
    private GradeInfoId infoId;

    @Column(nullable = false)
    private Boolean isPass;

    @Enumerated(EnumType.STRING)
    private Score score;

}

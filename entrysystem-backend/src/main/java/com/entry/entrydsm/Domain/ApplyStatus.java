package com.entry.entrydsm.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplyStatus implements Serializable {

    @Id
    private Info i_id;

    @Column
    private boolean payment;

    @Column
    private boolean recipt;

    @Column
    private boolean final_submit;

    @Column
    private boolean pass_status;
}

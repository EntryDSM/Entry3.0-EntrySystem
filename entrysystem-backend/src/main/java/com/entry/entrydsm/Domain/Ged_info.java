package com.entry.entrydsm.Domain;

import com.entry.entrydsm.user.User;

import javax.persistence.*;

@Entity
public class Ged_info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ged_id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.GED;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User uu;
}

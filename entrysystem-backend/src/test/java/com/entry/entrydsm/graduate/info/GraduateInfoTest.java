package com.entry.entrydsm.graduate.info;

import com.entry.entrydsm.user.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraduateInfoTest {

    @Test
    public void name() {
        GraduateInfo.builder()
                .user(new User())
                .graduateYear(null)
                .build();
    }
}
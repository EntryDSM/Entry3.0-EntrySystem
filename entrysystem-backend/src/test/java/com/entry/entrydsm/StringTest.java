package com.entry.entrydsm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void subString() {
        String jwtTokenPrefix = "JWT ";
        String aString = jwtTokenPrefix + "a_token_string";

        assertThat(aString.substring(jwtTokenPrefix.length())).isEqualTo("a_token_string");

    }
}

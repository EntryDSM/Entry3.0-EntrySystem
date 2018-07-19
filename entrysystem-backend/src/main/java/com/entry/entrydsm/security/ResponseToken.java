package com.entry.entrydsm.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseToken {

    private String access_token;
    private String refresh_token;
}

package com.entry.entrydsm.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ResponseToken {

    private String access_token;
    private String refresh_token;
}

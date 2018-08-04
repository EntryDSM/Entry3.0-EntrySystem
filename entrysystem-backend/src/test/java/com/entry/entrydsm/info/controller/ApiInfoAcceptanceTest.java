package com.entry.entrydsm.info.controller;

import com.entry.entrydsm.common.response.ResponseModel;
import com.entry.entrydsm.info.domain.Info;
import com.entry.entrydsm.support.AcceptanceTest;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiInfoAcceptanceTest extends AcceptanceTest {

    @Test
    public void setUp() throws Exception {
        ResponseEntity<ResponseModel<Info>> response = template().exchange("/api/me/info", HttpMethod.GET, new HttpEntity<>(defaultUserAuthorizationHeader()), new ParameterizedTypeReference<ResponseModel<Info>>() {
        });

        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody().getData()).isEqualTo(defaultUser().getInfo());
    }
}
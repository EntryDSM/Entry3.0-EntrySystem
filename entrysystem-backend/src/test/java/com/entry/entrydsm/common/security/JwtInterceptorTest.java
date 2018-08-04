package com.entry.entrydsm.common.security;

import com.entry.entrydsm.support.AcceptanceTest;
import com.entry.entrydsm.user.User;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


public class JwtInterceptorTest extends AcceptanceTest {

    @Test
    public void 토큰_없이_요청() {
        ResponseEntity<Void> response = template().exchange("/", HttpMethod.GET, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void 유효하지_않은_토큰() {
        ResponseEntity<Void> response = template().exchange("/", HttpMethod.GET, new HttpEntity<>(prefixedAuthorizationHeader("invalid token")), Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void 유효한_토큰() {
        ResponseEntity<User> response = template().exchange("/", HttpMethod.GET, new HttpEntity<>(defaultUserAuthorizationHeader()), User.class);
        System.out.println(response.getBody());
        System.out.println(defaultUser());
        assertThat(response.getBody()).isEqualTo(defaultUser());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
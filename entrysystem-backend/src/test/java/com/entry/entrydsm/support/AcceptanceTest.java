package com.entry.entrydsm.support;

import com.entry.entrydsm.jwt.Jwt;
import com.entry.entrydsm.user.User;
import com.entry.entrydsm.user.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AcceptanceTest {
    private static final String DEFAULT_USER_ID = "default_user_id";

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Jwt jwtService;

    @Value("${jwt.prefix}")
    private String jwtHeaderPrefix;


    protected TestRestTemplate template() {
        return template;
    }

    @Bean
    protected HttpHeaders defaultUserAuthorizationHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", jwtHeaderPrefix + jwtService.createToken(defaultUser()));
        return headers;
    }

    protected User defaultUser() {
        return userRepository.findById(DEFAULT_USER_ID).get();
    }
}

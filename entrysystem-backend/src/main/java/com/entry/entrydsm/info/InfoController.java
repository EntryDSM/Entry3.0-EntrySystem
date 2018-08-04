package com.entry.entrydsm.info;

import com.entry.entrydsm.common.security.jwt.JwtAuthRequired;
import com.entry.entrydsm.common.security.jwt.JwtAuthenticated;
import com.entry.entrydsm.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InfoController {

    @GetMapping
    @JwtAuthRequired
    public User isGood(@JwtAuthenticated User user) {
        return user;
    }
}

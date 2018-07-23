package com.entry.entrydsm.security;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Crypto implements PasswordEncoder, InitializingBean {

    private Object salt = null;
    private ShaPasswordEncoder shaPasswordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        shaPasswordEncoder = new ShaPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return shaPasswordEncoder.encodePassword(rawPassword.toString(), salt);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return shaPasswordEncoder.isPasswordValid(encodedPassword, rawPassword.toString(), salt);
    }

    public void setSalt(Object salt) {
        this.salt = salt;
    }

}
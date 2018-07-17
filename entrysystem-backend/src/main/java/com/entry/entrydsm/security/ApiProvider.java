package com.entry.entrydsm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ApiProvider implements AuthenticationProvider {

    @Autowired
    private JWT jwt;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String credentials = (String) authentication.getCredentials();
        ApiUser user = new ApiUser(principal, credentials, null);
        try {
            String token = jwt.createToken(user, generateAuthorities(Role.USER));
            user.setDetails(new ResponseToken(token, jwt.createRefreshToken(token)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Role role) {

        return AuthorityUtils.createAuthorityList("ROLE_" + role);
    }
}

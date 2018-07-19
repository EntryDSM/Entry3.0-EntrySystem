package com.entry.entrydsm.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiUser extends AbstractAuthenticationToken {

    private  String principal;
    private String credentials;

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */

    public ApiUser(String email, String password , Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = email;
        this.credentials = password;
    }


    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}

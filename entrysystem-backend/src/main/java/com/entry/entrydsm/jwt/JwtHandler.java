package com.entry.entrydsm.jwt;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@Service
public class JwtHandler extends HandlerInterceptorAdapter {

    private static final Pattern Bearer = Pattern.compile("^Bearer$");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = obtainAuthorizationToken(request.getHeader("Authorization"));
        if (token == null) {
            response.setStatus(403);
        } else {
            return true;
        }
        return false;
    }


    private String obtainAuthorizationToken(String authorization) {
        if (authorization != null) {
            String[] parts = authorization.split(" ");
            if (parts.length == 2) {
                return Bearer.matcher(parts[0]).matches() ? parts[1] : null;
            }
        }
        return null;
    }

}

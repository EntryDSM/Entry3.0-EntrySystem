package com.entry.entrydsm.common.security.jwt;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Value("${jwt.prefix}")
    private String tokenPrefix;

    @Autowired
    private Jwt jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (!handlerMethod.hasMethodAnnotation(JwtAuthRequired.class)) {
            return true;
        }

        String jwtHeader = request.getHeader("Authorization");

        if (!tokenValidation(jwtHeader)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }

    private boolean tokenValidation(String jwtHeader) {
        return jwtHeader != null
                && jwtHeader.startsWith(tokenPrefix)
                && jwt.validation(jwtHeader.substring(tokenPrefix.length()));
    }


}

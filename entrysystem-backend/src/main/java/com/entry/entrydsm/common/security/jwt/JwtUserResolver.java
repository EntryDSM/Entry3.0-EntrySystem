package com.entry.entrydsm.common.security.jwt;

import com.entry.entrydsm.exception.UnauthenticatedException;
import com.entry.entrydsm.user.User;
import com.entry.entrydsm.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

@Component
public class JwtUserResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private Jwt jwt;

    @Value("${jwt.prefix}")
    private String tokenPrefix;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasMethodAnnotation(JwtAuthRequired.class)
                && parameter.hasParameterAnnotation(JwtAuthenticated.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String authorizationHeader = webRequest.getHeader("Authorization");

        return findUser(
                jwt.getUserId(Objects.requireNonNull(authorizationHeader)
                        .substring(tokenPrefix.length()))
        );
    }

    private User findUser(String userId) {
        return userRepository.findById(userId).orElseThrow(UnauthenticatedException::new);
    }

}

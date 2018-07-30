package com.entry.entrydsm.jwt;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import com.entry.entrydsm.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class Jwt {

    @Value("${issuer}")
    private String issuer;
    @Value("${clientId}")
    private String clientId;
    @Value("${exp}")
    private int exp;
    @Value("${refreshExp}")
    private int refreshExp;

    private JWTSigner signer;
    private JWTVerifier jwtVerifier;

    @PostConstruct
    public void initPropertiesSetting() {
        signer = new JWTSigner(Base64.decodeBase64("들어갈 Key"));
        jwtVerifier = new JWTVerifier(Base64.decodeBase64("들어갈 Key"), clientId, issuer);
    }

    private JWTSigner.Options initSeting(Integer exp) {
        JWTSigner.Options options = new JWTSigner.Options();
        options.setAlgorithm(Algorithm.HS512);
        options.setJwtId(true);
        options.setIssuedAt(true);
        options.setExpirySeconds(exp);
        return options;
    }

    public String createToken(User user) {
        return createToken(user.getId());
    }

    public String createToken(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("iss", issuer);
        map.put("userId", userId);
        return signer.sign(map, initSeting(exp));
    }

    public String createRefreshToken(String token) throws Exception {
        Map<String, Object> claims = authToken(token);
        claims.remove("exp");
        claims.remove("iat");
        claims.remove("jti");
        return signer.sign(claims, initSeting(refreshExp));
    }

    public Map<String, Object> authToken(String token) throws Exception {
        return jwtVerifier.verify(token);
    }
}

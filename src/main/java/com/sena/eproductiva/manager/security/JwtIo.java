package com.sena.eproductiva.manager.security;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sena.eproductiva.manager.util.GsonUtil;

import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;

@Component
public class JwtIo {
    
    @Value("${jms.jwt.token.secret}")
    private String SECRET;
    @Value("${jms.jwt.timezone}")
    private String TIMEZONE;
    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;
    @Value("${jms.jwt.issuser}")
    private String ISSUER;

    public String generateToken(Object src){

        String subject = GsonUtil.serializable(src);

        Signer signer = HMACSigner.newSHA256Signer(SECRET);     

        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);

        ZonedDateTime zdt = ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRES_IN); 

        JWT jwt = new JWT().setIssuer(subject)
        .setIssuedAt(ZonedDateTime.now(tz.toZoneId()))
        .setSubject(subject)
        .setExpiration(zdt);

        return JWT.getEncoder().encode(jwt, signer); 
    }

    public boolean validateToken(String encodeJWT){

        JWT jwt = jwt(encodeJWT);

        return jwt.isExpired();
    }

    public String getPayload(String encodeJWT){

        JWT jwt = jwt(encodeJWT);
        return jwt.subject ;
    }

    private JWT jwt(String encodeJWT){

        Verifier verifier = HMACVerifier.newVerifier(SECRET);

        return JWT.getDecoder().decode(encodeJWT, verifier);
    }


}

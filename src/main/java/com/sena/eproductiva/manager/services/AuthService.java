package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.JwtResponse;
import com.sena.eproductiva.manager.security.JwtIo;
import com.sena.eproductiva.manager.util.DateUtil;

@Service
public class AuthService {
    
    @Autowired
    private JwtIo jwtIo;

    @Autowired
    private DateUtil dateUtil;

    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;

    public JwtResponse logIn( String clientId, String clientSecret){
        JwtResponse jwt = JwtResponse.builder()
        .tokenType("bearer")
        .accesToken(jwtIo.generateToken("ya cambie el token xde"))
        .issuedAt(dateUtil.getDateMilis() + "")
        .clientId(clientId)
        .expiresIn(EXPIRES_IN)
        .build();
        return jwt; 
    }
}

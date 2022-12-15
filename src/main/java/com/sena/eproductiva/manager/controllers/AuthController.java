package com.sena.eproductiva.manager.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.exeptions.ApiUnautorized;
import com.sena.eproductiva.manager.services.AuthService;
import com.sena.eproductiva.manager.validator.AuthValidator;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping(path = ("/oauth"))
public class AuthController {

    @Autowired 
    private AuthService authService;  

    @Autowired
    private AuthValidator authValidator;

    @PostMapping(path = "client_credential/token" ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
     produces = MediaType.APPLICATION_JSON_VALUE  )
    public ResponseEntity<Object> logIn(@RequestBody LinkedMultiValueMap<String, String> paramMap, 
    @RequestParam("grant_type") String grantType) throws ApiUnautorized{

        System.out.println(paramMap.getFirst("client_id")+paramMap.getFirst("client_secret"));
        // authValidator.validate(paramMap, grantType);
        return ResponseEntity.ok(authService.logIn(paramMap.getFirst("client_id"),paramMap.getFirst("client_secret")));
        
    }
    
}

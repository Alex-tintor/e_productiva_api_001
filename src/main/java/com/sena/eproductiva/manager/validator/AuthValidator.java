package com.sena.eproductiva.manager.validator;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.stereotype.Component;


import com.sena.eproductiva.manager.exeptions.ApiUnautorized;

@Component
public class AuthValidator {

    private static final String CLIENT_CREDENTIAL = "client_credential";

    public void validate(HashMap<String, String> paramMap, String grantType) throws ApiUnautorized{

        if(grantType.isEmpty() || grantType.isBlank()||! grantType.equals(CLIENT_CREDENTIAL))
            message("el campo grant_type es invalido");
        if(Objects.isNull(paramMap) || paramMap.get("client_id").isEmpty() || paramMap.get("client_secret").isEmpty())
            message("client id y/o client secret son invalidos");
    }  

    private void message(String message) throws ApiUnautorized{
        throw new ApiUnautorized(message);
    }
    
}

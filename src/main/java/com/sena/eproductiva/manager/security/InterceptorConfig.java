package com.sena.eproductiva.manager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class InterceptorConfig implements WebMvcConfigurer{


    @Value("${jms.jwt.security.enabled:false}")
    private boolean securityEnabled;

    @Autowired
    private InterceptorJwtIo interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        if(securityEnabled)
            registry.addInterceptor(interceptor);
    }
    
}

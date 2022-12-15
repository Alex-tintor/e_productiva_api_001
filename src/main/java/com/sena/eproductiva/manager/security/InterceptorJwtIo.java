package com.sena.eproductiva.manager.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class InterceptorJwtIo implements HandlerInterceptor {

    @Value("${jms.jwt.token.auth.path}")
    private String AUTH_PATH;
    @Value("#{'${jms.jwt.excluded.path}'.split(',')}" )
    private List<String> excluded;

    @Autowired
    private JwtIo jwtIo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception{

        boolean validate = false;

        String url = request.getRequestURI(); 

        if(url.equals(AUTH_PATH)|| excluded(url))
            validate = true;

        if(validate && request.getHeader("Authorization")!= null && !request.getHeader("Authorization").isEmpty()){
                String token = request.getHeader("Authorization").replace("Bearer","");

                validate = !jwtIo.validateToken(token);
            }
        if(validate)
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);



        return validate;
    }

    private boolean excluded(String path){
        boolean result = false;
        
        for(String ex : excluded){
            if(ex.equals("#")&& ex.equals(path))
                result = true;  
        }

        return result;
    }
    
}

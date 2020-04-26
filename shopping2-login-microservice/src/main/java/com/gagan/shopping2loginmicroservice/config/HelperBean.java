package com.gagan.shopping2loginmicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 12:56
 */

@Configuration
public class HelperBean {


}
/**
 * Use it for checking if user is authenticated
if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        return currentUserName;
        }
*/
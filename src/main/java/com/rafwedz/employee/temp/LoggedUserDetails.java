package com.rafwedz.employee.temp;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


public class LoggedUserDetails {

    private static String LoggedUserName;

    public static String getLoggedUserName() {
        return LoggedUserName;
    }

    public static void setLoggedUserName() {
        SecurityContext context=SecurityContextHolder.getContext();
        LoggedUserName=context.getAuthentication().getName();


    }

}

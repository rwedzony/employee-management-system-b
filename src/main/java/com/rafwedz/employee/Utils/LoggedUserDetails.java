package com.rafwedz.employee.Utils;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


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

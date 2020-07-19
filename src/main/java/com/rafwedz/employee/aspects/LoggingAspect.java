package com.rafwedz.employee.aspects;

import com.rafwedz.employee.Utils.LoggedUserDetails;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {


    @Before(value="@annotation(com.rafwedz.employee.annotations.Logging)")
    public void getLoggedUserName(){
        LoggedUserDetails.setLoggedUserName();
    }
}

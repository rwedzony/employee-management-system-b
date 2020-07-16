package com.rafwedz.employee.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    @Before(value="@annotation(com.rafwedz.employee.annotations.Logging)")
    public void getUserName(){
        System.out.println("Hello world!");
    }
}

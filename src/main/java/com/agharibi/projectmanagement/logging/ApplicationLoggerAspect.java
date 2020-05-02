package com.agharibi.projectmanagement.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.agharibi.projectmanagement.controllers..*)")
    public void definePackagePointcuts() {
        // empty method, just to name the location in the pointcut
    }

    @After("definePackagePointcuts()")
    public void log() {
        log.debug(" --------------------------------------------- ");
    }
}
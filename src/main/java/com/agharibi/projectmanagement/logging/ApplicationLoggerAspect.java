package com.agharibi.projectmanagement.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.agharibi.projectmanagement.controllers..*)")
    public void definePackagePointcuts() {
        // empty method, just to name the location in the pointcut
    }

    @Around("definePackagePointcuts()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        log.debug(" \n \n \n ");
        beforeMethodExecution(joinPoint);
        Object proceed = joinPoint.proceed();
        afterMethodExecution(joinPoint);

        return proceed;
    }

    private void beforeMethodExecution(ProceedingJoinPoint joinPoint) {
        log.debug("   ***********  Before method execution   ********  \n {}.{} () with arguments[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        log.debug(" ------------------------------------- \n\n");
    }

    private void afterMethodExecution(ProceedingJoinPoint joinPoint) {
        log.debug("   ***********  After method execution   ********  \n {}.{} () with arguments[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        log.debug(" ------------------------------------- \n\n");
    }

}

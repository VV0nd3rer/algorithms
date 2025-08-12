package com.home.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAdvice {
    @Around("@annotation(TrackExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = currentTimeMillis();
        Object object = point.proceed();
        long endTime = currentTimeMillis();
        log.info("Tracking execution time... " +
                "Class name: " + point.getSignature().getDeclaringTypeName() +
                "; Method name : " + point.getSignature().getName() +
                "; Execution time: " + (endTime - startTime) + "ms.");

        return object;
    }

}

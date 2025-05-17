package com.home.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExecutionTimeAdviceTest {
    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    @InjectMocks
    private ExecutionTimeAdvice executionTimeAdvice;
    @Test
    void testExecutionTime() throws Throwable {
        //Given
        when(proceedingJoinPoint.proceed()).thenAnswer(
                invocation -> {
                    Thread.sleep(100);
                    return null;
                }
        );
        when(proceedingJoinPoint.getSignature()).thenReturn(mock(MethodSignature.class));

        //When
        executionTimeAdvice.logExecutionTime(proceedingJoinPoint);

        //Then
        verify(proceedingJoinPoint, times(1)).proceed();
    }
}
package com.magioli.desafiobackenditau.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ComportamentoLogAspect {

    @Around("execution(* com.magioli.desafiobackenditau..*.*(..))")
    public Object LoggingAtividadeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        String metodo = joinPoint.getSignature().toShortString();
        log.debug("Executando método: {}", metodo);
        Object result = joinPoint.proceed();
        log.debug("Método {} executado com sucesso!", metodo);
        return result;
    }
}

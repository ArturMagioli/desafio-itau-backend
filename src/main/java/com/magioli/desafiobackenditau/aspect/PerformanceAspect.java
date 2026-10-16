package com.magioli.desafiobackenditau.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* com.magioli.desafiobackenditau.transacao.util.GeradorDeEstatisticas.calcularEstatisticas(..))")
    public Object estatisticaPerformanceCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempoInicial = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long tempoFinal = System.currentTimeMillis();
        log.debug("Tempo para calcular estatísticas: {}ms!", tempoFinal - tempoInicial);
        return result;
    }
}

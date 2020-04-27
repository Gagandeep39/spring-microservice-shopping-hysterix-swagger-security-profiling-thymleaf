/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-24 12:15:51
 * @modify date 2020-04-24 12:15:51
 * @desc Logger
 */
package com.gagan.shopping2purchasemicroservice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {

    static Logger logger = LoggerFactory.getLogger(AspectLogger.class);

    @Pointcut("execution(* com.gagan.*.*.*.*(..)))")
    public void everyWhere() {}

    @Before("everyWhere()")
    public void logBefore(JoinPoint point) {
        logger.debug("@Before class: " + point.getTarget().getClass().getSimpleName());
        logger.debug("@Before method: " + point.getSignature().toShortString());
         logger.debug("Arguments: ");
         Object[] objects = point.getArgs();
         for (Object object : objects) {
             logger.debug("->" + object);
         }
    }

    @AfterReturning(pointcut = "everyWhere()", returning = "result")
    public void logAfter(JoinPoint point, Object result) {
        logger.debug("@AfterReturning class: " + point.getTarget().getClass().getSimpleName());
        logger.debug("@AfterReturning method: " + point.getSignature().toShortString());
         logger.debug("->Returning Value: " + result);
    }

}
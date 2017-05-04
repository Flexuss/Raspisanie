package ru.kpfu.itis.dmitry_ivanov.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitry on 04.05.2017.
 */

@Aspect
@Component
public class MyLogger {
    private static Logger log = Logger.getLogger(MyLogger.class);

    @After("execution(* ru.kpfu.itis.dmitry_ivanov.controllers.AdminController.postSchedule())")
    public void logAfterSchedulePost() {
        log.info("Admin add new Professor");
    }

    @After("execution(* ru.kpfu.itis.dmitry_ivanov.controllers.AdminController.edit())")
    public void logAfterAddingSchedule() {
        log.info("Admin edit schedule");
    }

    @Before("execution(* ru.kpfu.itis.dmitry_ivanov.services.*.*(..))")
    public void before() {
        log.info("Service method is being executed..");
    }
}

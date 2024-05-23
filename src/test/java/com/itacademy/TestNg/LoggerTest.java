package com.itacademy.TestNg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    private static final Logger LOGGER= LogManager.getLogger(LoggerTest.class);
    @Test
    public void loggerTest(){
        LOGGER.info("Hello world");
    }
}

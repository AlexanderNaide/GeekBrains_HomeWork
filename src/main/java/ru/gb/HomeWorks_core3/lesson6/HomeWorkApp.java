package ru.gb.HomeWorks_core3.lesson6;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
//import java.util.logging.Logger;

public class HomeWorkApp {
//    private static final Logger logger = Logger.getLogger("");
    private static final Logger logger = LogManager.getLogger(HomeWorkApp.class);
    public static void main(String[] args) {
/*        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.log(Level.INFO, "Connection");
        logger.setLevel(Level.WARNING);*/


        logger.info("Info");

        if(logger.isDebugEnabled()) {
            logger.debug("Debug");
        }

        logger.info("Info message {}", "(Insert message)");
        logger.warn("Warning");
        logger.error("Error");



    }
}

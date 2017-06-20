package com.skplanet.plalab.googleDrive.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kyeongmin kim
 */
public class ApplicationLoggerNameFactory {

    private static final String APPLICATION_LOGGER_NAME = "ApplicationLogger";
    private static final String REST_LOGGER_NAME = "RestLogger";

    private static final Logger applicationLogger = LoggerFactory.getLogger(APPLICATION_LOGGER_NAME);
    private static final Logger httpLogger = LoggerFactory.getLogger(REST_LOGGER_NAME);

    public static Logger getApplicationLogger() {
        return applicationLogger;
    }

    public static Logger getRestLogger() {
        return httpLogger;
    }
}

package framework.logger;

import org.apache.log4j.Logger;

public class LoggerLog {

    private static final Logger LOG = Logger.getLogger(LoggerLog.class);

    public static void logInfo(String message) {
        LOG.info(message);
    }

    public static void logError(String message) {
        LOG.error(message);
    }

}

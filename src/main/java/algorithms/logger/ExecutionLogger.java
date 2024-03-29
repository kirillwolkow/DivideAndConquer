package algorithms.logger;

import java.util.logging.*;

public class ExecutionLogger {
    private static final Logger logger = Logger.getLogger(ExecutionLogger.class.getName());

    static {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomFormatter());

        logger.addHandler(consoleHandler);
    }

    public static void logExecutionTimes(final Level level, final String message) {
        logger.log(level, message);
    }

    static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return String.format("%1$tF %1$tT %2$s %3$s %4$s %5$s%n",
                    record.getMillis(),
                    record.getSourceClassName(),
                    record.getSourceMethodName(),
                    record.getLevel().getName(),
                    record.getMessage()
            );
        }
    }
}

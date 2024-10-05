package common.listener;

import common.systemLogger.AppLogger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.Logger;

public class TestListener implements TestExecutionExceptionHandler {

    private static final Logger logger = AppLogger.getLogger(TestListener.class);

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) {
        logger.error("Test failed: {}", context.getDisplayName());
        logger.error("Problem is: {}", throwable.getMessage(), throwable);
    }
}
